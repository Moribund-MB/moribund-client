package com.github.moribund.objects.playable.players.containers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.graphics.sprites.SpriteContainer;
import com.github.moribund.graphics.sprites.SpriteFile;
import com.github.moribund.net.packets.items.EquipItemPacket;
import com.github.moribund.net.packets.items.ItemOnItemPacket;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import lombok.val;

/**
 * The {@code Inventory} {@link ItemContainer}.
 */
public class Inventory extends ItemContainer implements DrawableUIAsset {

    /**
     * The capacity of the slots in the inventory.
     */
    public static final int SLOTS = 5;

    /**
     * The sprite of a single equipment inventory.
     */
    private final Sprite singularSprite;

    /**
     * The {@link Sprite} array of slots.
     */
    private Sprite[] slots;

    /**
     * Has a slot been selected?
     */
    private boolean itemSelected;

    /**
     * The first slot selected.
     */
    private int slotSelected1;

    /**
     * The second slot selected.
     */
    private int slotSelected2;

    /**
     * Makes a new inventory item container, calling {@link Inventory#initiateUI()}.
     */
    public Inventory() {
        singularSprite = SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_UNSELECTED);
        slots = new Sprite[SLOTS];
        slotSelected1 = -1;
        slotSelected2 = -1;
        initiateUI();
    }

    /**
     * Initiates all the data in {@link Inventory#slots}.
     */
    private void initiateUI() {
        val centeringConstant = 175; // todo find a more mathematical way to do this
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Sprite(singularSprite);
            slots[i].setX(Gdx.graphics.getWidth() - (slots[i].getWidth() * (i + 1)) - centeringConstant);
            slots[i].setY(0);
            slots[i].setAlpha(0.8f);
        }
    }

    @Override
    public void draw(Batch batch) {
        for (Sprite sprite : slots) {
            sprite.draw(batch);
        }
        for (int i = 0; i < items.size(); i++) {
            items.get(i).draw(i, Gdx.graphics.getWidth() - (singularSprite.getWidth() * SLOTS), batch);
        }
    }

    /**
     * Handles the click action of the inventory interface.
     * @param player The player that clicked the inventory interface.
     * @param slot The slot that was clicked.
     * @implNote The {@link Inventory#click(PlayableCharacter, int)} method assumes the y-coordinate of the inventory
     *           interface has been checked.
     */
    public void click(PlayableCharacter player, int slot) {
        if (slot != -1) {
            if (!itemSelected) {
                itemSelected = true;
                slotSelected1 = slot;
            } else if (slot != slotSelected1) {
                slotSelected2 = slot;
                sendItemOnItemPacket(player);
                resetVariables();
            } else {
                sendEquipItemPacket(player);
                resetVariables();
            }
        }
    }

    /**
     * Gets the slot of a click.
     * @param screenX The screen x-coordinate clicked.
     * @return The slot based on the coordinate clicked.
     */
    public int getSlotFromClick(int screenX) {
        val increment = 95;
        val startingXLeft = 279;
        val startingXRight = startingXLeft + increment;
        for (int i = 0; i < slots.length; i++) {
            if (screenX >= (startingXLeft + (increment * (i + 1))) && screenX <= (startingXRight + (increment * (i + 1)))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Sends the equip item packet.
     * @param player The player that is equipping the item.
     */
    private void sendEquipItemPacket(PlayableCharacter player) {
        val equipItemPacket = new EquipItemPacket(player.getGameId(), player.getPlayerId(), slotSelected1);
        MoribundClient.getInstance().getPacketDispatcher().sendTCP(equipItemPacket);
    }

    /**
     * Resets the variables to allow for new actions.
     */
    private void resetVariables() {
        itemSelected = false;
        slotSelected1 = -1;
        slotSelected2 = -1;
    }

    /**
     * Sends the item on item packet.
     * @param playableCharacter The player that is using one item on another.
     */
    private void sendItemOnItemPacket(PlayableCharacter playableCharacter) {
        val itemOnItemPacket = new ItemOnItemPacket(playableCharacter.getGameId(), playableCharacter.getPlayerId(), slotSelected1, slotSelected2);
        MoribundClient.getInstance().getPacketDispatcher().sendTCP(itemOnItemPacket);
    }
}

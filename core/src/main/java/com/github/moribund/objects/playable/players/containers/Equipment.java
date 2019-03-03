package com.github.moribund.objects.playable.players.containers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.graphics.sprites.SpriteContainer;
import com.github.moribund.graphics.sprites.SpriteFile;
import com.github.moribund.net.packets.items.UnequipItemPacket;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import lombok.val;

/**
 * The {@code Equipment} {@link ItemContainer}.
 */
public class Equipment extends ItemContainer implements DrawableUIAsset {

    /**
     * The capacity of the slots in the equipment.
     */
    private static final int SLOTS = 2;

    /**
     * The sprite of a single equipment background.
     */
    private final Sprite singularSprite;

    /**
     * The {@link Sprite} array of slots.
     */
    private final Sprite[] slots;

    /**
     * Makes a new equipment item container, calling {@link Equipment#initiateUI()}.
     */
    public Equipment() {
        singularSprite = SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_SELECTED);
        slots = new Sprite[SLOTS];
        initiateUI();
    }

    /**
     * Initiates all the data in {@link Equipment#slots}.
     */
    private void initiateUI() {
        val centeringConstant = 175; // todo find a more mathematical way to do this
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Sprite(singularSprite);
            slots[i].setX(Gdx.graphics.getWidth() - (slots[i].getWidth() * (Inventory.SLOTS + (i + 1))) - centeringConstant);
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
            items.get(i).draw(i, Gdx.graphics.getWidth() - (singularSprite.getWidth() * (Inventory.SLOTS + SLOTS)), batch);
        }
    }

    /**
     * Handles the click action of the equipment interface.
     * @param player The player that clicked the equipment interface.
     * @param screenX The x-coordinate of where the equipment was clicked.
     * @implNote This method assumes the y-coordinate of the equipment interface has been checked.
     */
    public void click(PlayableCharacter player, int screenX) {
        val increment = 95;
        val startingXLeft = 184;
        val startingXRight = startingXLeft + increment;
        for (int i = 0; i < slots.length; i++) {
            if (screenX >= (startingXLeft + (increment * i)) && screenX <= (startingXRight + (increment * i))) {
                sendUnequipItemPacket(player, i);
                break;
            }
        }
    }

    /**
     * Sends the unequip item packet.
     * @param player The player that is unequipping the item.
     * @param slot The slot of the equipment being unequipped.
     */
    private void sendUnequipItemPacket(PlayableCharacter player, int slot) {
        val unequipItemPacket = new UnequipItemPacket(player.getGameId(), player.getPlayerId(), slot);
        MoribundClient.getInstance().getPacketDispatcher().sendTCP(unequipItemPacket);
    }
}

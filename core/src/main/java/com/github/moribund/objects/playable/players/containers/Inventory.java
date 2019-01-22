package com.github.moribund.objects.playable.players.containers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.SpriteContainer;
import com.github.moribund.graphics.SpriteFile;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.net.packets.items.ItemOnItemPacket;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import lombok.Getter;
import lombok.val;

public class Inventory extends ItemContainer implements DrawableUIAsset {
    public static final int SLOTS = 5;
    private final Sprite singularSprite;
    private Sprite[] slots;
    @Getter
    private Rectangle boundingRectangle;
    private boolean itemSelected;
    private int slotSelected1;
    private int slotSelected2;

    public Inventory() {
        singularSprite = SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_UNSELECTED);
        slots = new Sprite[SLOTS];
        slotSelected1 = -1;
        slotSelected2 = -1;
        initiateUI();
    }

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
    public void draw(SpriteBatch spriteBatch) {
        for (Sprite sprite : slots) {
            sprite.draw(spriteBatch);
        }
        for (int i = 0; i < items.size(); i++) {
            items.get(i).draw(i, Gdx.graphics.getWidth() - (singularSprite.getWidth() * SLOTS), spriteBatch);
        }
    }

    public void click(PlayableCharacter playableCharacter, int screenX) {
        val increment = 95;
        val startingXLeft = 279;
        val startingXRight = startingXLeft + increment;
        for (int i = 0; i < slots.length; i++) {
            if (screenX >= (startingXLeft + (increment * (i + 1))) && screenX <= (startingXRight + (increment * (i + 1)))) {
                if (!itemSelected) {
                    itemSelected = true;
                    slotSelected1 = i;
                } else if (i != slotSelected1) {
                    slotSelected2 = i;
                    sendItemOnItemPacket(playableCharacter);
                    resetVariables();
                } else {
                    playableCharacter.equipItem(slotSelected1);
                    resetVariables();
                }
                break;
            }
        }
    }

    private void resetVariables() {
        itemSelected = false;
        slotSelected1 = -1;
        slotSelected2 = -1;
    }

    private void sendItemOnItemPacket(PlayableCharacter playableCharacter) {
        val itemOnItemPacket = new ItemOnItemPacket(playableCharacter.getGameId(), playableCharacter.getPlayerId(), slotSelected1, slotSelected2);
        MoribundClient.getInstance().getPacketDispatcher().sendTCP(itemOnItemPacket);
    }
}

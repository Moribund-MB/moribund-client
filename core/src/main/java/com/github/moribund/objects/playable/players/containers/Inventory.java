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
    private static final int SLOTS = 5;
    private Sprite[] unselected;
    private Sprite[] selected;
    @Getter
    private Rectangle boundingRectangle;
    private boolean itemSelected;
    private int slotSelected1;
    private int slotSelected2;

    public Inventory() {
        super();
        unselected = new Sprite[SLOTS];
        selected = new Sprite[2];
        slotSelected1 = -1;
        slotSelected2 = -1;
        initiateUI();
    }

    private void initiateUI() {
        val centeringConstant = 175; // todo find a more mathematical way to do this
        for (int i = 0; i < unselected.length; i++) {
            unselected[i] = new Sprite(SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_UNSELECTED));
            unselected[i].setX(Gdx.graphics.getWidth() - (unselected[i].getWidth() * (i + 1)) - centeringConstant);
            unselected[i].setY(0);
            unselected[i].setAlpha(0.8f);
        }
        for (int i = 0; i < selected.length; i++) {
            selected[i] = new Sprite(SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_SELECTED));
            selected[i].setX(Gdx.graphics.getWidth() - (selected[i].getWidth() * (unselected.length + (i + 1))) - centeringConstant);
            selected[i].setY(0);
            selected[i].setAlpha(0.8f);
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        for (Sprite sprite : unselected) {
            sprite.draw(spriteBatch);
        }
        for (Sprite sprite : selected) {
            sprite.draw(spriteBatch);
        }
        for (int i = 0; i < items.size(); i++) {
            items.get(i).draw(i, spriteBatch);
        }
    }

    public void click(PlayableCharacter playableCharacter, int screenX) {
        val increment = 95;
        val startingXLeft = 279;
        val startingXRight = startingXLeft + increment;
        for (int i = 0; i < unselected.length; i++) {
            if (screenX >= (startingXLeft + (increment * (i + 1))) && screenX <= (startingXRight + (increment * (i + 1)))) {
                if (!itemSelected) {
                    itemSelected = true;
                    slotSelected1 = i;
                } else {
                    slotSelected2 = i;
                    sendItemOnItemPacket(playableCharacter);
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

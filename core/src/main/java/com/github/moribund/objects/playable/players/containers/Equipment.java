package com.github.moribund.objects.playable.players.containers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.graphics.SpriteContainer;
import com.github.moribund.graphics.SpriteFile;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import lombok.val;

public class Equipment extends ItemContainer implements DrawableUIAsset {
    private static final int SLOTS = 2;
    private final Sprite singularSprite;
    private Sprite[] slots;

    public Equipment() {
        singularSprite = SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_SELECTED);
        slots = new Sprite[SLOTS];
        initiateUI();
    }

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
}

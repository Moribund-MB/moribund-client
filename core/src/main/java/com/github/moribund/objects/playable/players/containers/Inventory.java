package com.github.moribund.objects.playable.players.containers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.graphics.SpriteContainer;
import com.github.moribund.graphics.SpriteFile;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import lombok.val;

public class Inventory extends ItemContainer implements DrawableUIAsset {
    public static final int SLOTS = 5;

    public Inventory() {
        super();
    }

    @Override
    public Sprite getSprite() {
        return null;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        val unselected = new Sprite[SLOTS];
        val centeringConstant = 175; // todo find a more mathematical way to do this
        for (int i = 0; i < unselected.length; i++) {
            unselected[i] = new Sprite(SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_UNSELECTED));
            unselected[i].setX(Gdx.graphics.getWidth() - (unselected[i].getWidth() * (i + 1)) - centeringConstant);
            unselected[i].setY(0);
            unselected[i].setAlpha(0.8f);
            unselected[i].draw(spriteBatch);
        }
        val selected = new Sprite[2];
        for (int i = 0; i < selected.length; i++) {
            selected[i] = new Sprite(SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_SELECTED));
            selected[i].setX(Gdx.graphics.getWidth() - (selected[i].getWidth() * (unselected.length + (i + 1))) - centeringConstant);
            selected[i].setY(0);
            selected[i].setAlpha(0.8f);
            selected[i].draw(spriteBatch);
        }
        for (int i = 0; i < items.size(); i++) {
            items.get(i).draw(i, spriteBatch);
        }
    }
}

package com.github.moribund.objects.nonplayable.items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.drawables.DrawableGameAsset;
import com.github.moribund.objects.attributes.Locatable;
import lombok.Getter;

public final class GroundItem implements Locatable, DrawableGameAsset {
    private final Sprite sprite;
    @Getter
    private final ItemType itemType;

    public GroundItem(ItemType itemType, float x, float y) {
        sprite = new Sprite(itemType.getSprite());
        this.itemType = itemType;
        sprite.setX(x);
        sprite.setY(y);
    }

    public static void addGroundItem(GroundItem groundItem) {
        MoribundClient.getInstance().getGroundItems().add(groundItem);
        MoribundClient.getInstance().getDrawableGameAssets().add(groundItem);
    }

    @Override
    public float getX() {
        return sprite.getX();
    }

    @Override
    public float getY() {
        return sprite.getY();
    }

    @Override
    public float getRotation() {
        return 0;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    public boolean matches(int itemId, float x, float y) {
        return itemType.getId() == itemId && getX() == x && getY() == y;
    }
}

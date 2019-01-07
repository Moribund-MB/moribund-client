package com.github.moribund.objects.nonplayable.items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.images.SpriteContainer;
import com.github.moribund.images.SpriteFile;
import com.github.moribund.objects.attributes.Drawable;
import com.github.moribund.objects.attributes.Locatable;
import com.github.moribund.objects.attributes.Pickable;

public final class GroundItem implements Locatable, Pickable, Drawable {
    private final Sprite sprite;

    public GroundItem(GroundItemType itemType, float x, float y) {
        sprite = new Sprite(getSpriteForType(itemType));
        sprite.setX(x);
        sprite.setY(y);
    }

    private Sprite getSpriteForType(GroundItemType itemType) {
        switch (itemType) {
            case ROCK: return SpriteContainer.getInstance().getSprite(SpriteFile.ROCK);
            case FEATHER: return SpriteContainer.getInstance().getSprite(SpriteFile.FEATHER);
            case STICK: return SpriteContainer.getInstance().getSprite(SpriteFile.STICK);
            case STRING: return SpriteContainer.getInstance().getSprite(SpriteFile.STRING);
        }
        return null;
    }

    public static void addGroundItem(GroundItem groundItem) {
        MoribundClient.getInstance().getPickables().add(groundItem);
        MoribundClient.getInstance().getDrawables().add(groundItem);
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
}

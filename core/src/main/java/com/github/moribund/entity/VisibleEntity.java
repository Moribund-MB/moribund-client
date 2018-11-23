package com.github.moribund.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.Getter;

public abstract class VisibleEntity implements Entity {
    private final Sprite sprite;
    @Getter
    protected Coordinate coordinate;

    VisibleEntity(Sprite sprite, Coordinate coordinate) {
        this.sprite = sprite;
        this.coordinate = coordinate;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprite.setPosition(coordinate.getX(), coordinate.getY());
        sprite.draw(spriteBatch);
    }
}

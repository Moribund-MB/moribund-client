package com.github.moribund.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public abstract class MovableEntity extends VisibleEntity {
    @Getter
    Map<Integer, Runnable> keyBinds;

    public MovableEntity(Sprite sprite, Coordinate startingCoordinate) {
        super(sprite, startingCoordinate);
        keyBinds = new HashMap<>();
        bindKeys();
    }

    abstract void moveUp();
    abstract void moveLeft();
    abstract void moveRight();
    abstract void moveDown();
    abstract void bindKeys();

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}

package com.github.moribund.entity;

import com.badlogic.gdx.Input;
import com.github.moribund.MoribundClient;
import com.github.moribund.images.SpriteFile;

public final class Player extends MovableEntity {

    public Player(Coordinate startingCoordinate) {
        super(MoribundClient.getInstance().getSpriteDrawer().getSprite(SpriteFile.DUMMY_PLAYER), startingCoordinate);
    }

    @Override
    void moveUp() {
        coordinate = coordinate.transmorphY(1);
    }

    @Override
    void moveLeft() {
        coordinate = coordinate.transmorphX(-1);
    }

    @Override
    void moveRight() {
        coordinate = coordinate.transmorphX(1);
    }

    @Override
    void moveDown() {
        coordinate = coordinate.transmorphY(-1);
    }

    @Override
    void bindKeys() {
        keyBinds.put(Input.Keys.UP, this::moveUp);
        keyBinds.put(Input.Keys.LEFT, this::moveLeft);
        keyBinds.put(Input.Keys.RIGHT, this::moveRight);
        keyBinds.put(Input.Keys.DOWN, this::moveDown);
    }
}
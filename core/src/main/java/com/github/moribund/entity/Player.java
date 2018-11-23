package com.github.moribund.entity;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.images.SpriteFile;

import java.util.HashMap;
import java.util.Map;

public class Player implements PlayableCharacter {
    private Coordinate coordinate;
    private Sprite sprite;
    private Map<Integer, Runnable> keyBinds;

    public Player(Coordinate startingCoordinate) {
        coordinate = startingCoordinate;
        sprite = MoribundClient.getInstance().getSpriteDrawer().getSprite(SpriteFile.DUMMY_PLAYER);
    }

    @Override
    public void moveUp() {
        coordinate = coordinate.transmorphY(1);
    }

    @Override
    public void moveDown() {
        coordinate = coordinate.transmorphY(-1);
    }

    @Override
    public void moveLeft() {
        coordinate = coordinate.transmorphX(-1);
    }

    @Override
    public void moveRight() {
        coordinate = coordinate.transmorphX(1);
    }

    @Override
    public Map<Integer, Runnable> getKeyBinds() {
        if (keyBinds == null) {
            keyBinds = new HashMap<>();
            bindKeys();
        }
        return keyBinds;
    }

    @Override
    public void bindKeys() {
        keyBinds.put(Input.Keys.UP, this::moveUp);
        keyBinds.put(Input.Keys.DOWN, this::moveDown);
        keyBinds.put(Input.Keys.LEFT, this::moveLeft);
        keyBinds.put(Input.Keys.RIGHT, this::moveRight);
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return coordinate;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.setPosition(coordinate.getX(), coordinate.getY());
        sprite.draw(spriteBatch);
    }
}

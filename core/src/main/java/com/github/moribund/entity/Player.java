package com.github.moribund.entity;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.images.SpriteFile;

import java.util.HashMap;
import java.util.Map;

public class Player implements PlayableCharacter {
    private Coordinate coordinate;
    private int playerId;
    private transient Sprite sprite;
    private transient Map<Integer, Runnable> keyBinds;

    public Player(int playerId) {
        this.playerId = playerId;
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
        keyBinds.put(Keys.UP, this::moveUp);
        keyBinds.put(Keys.DOWN, this::moveDown);
        keyBinds.put(Keys.LEFT, this::moveLeft);
        keyBinds.put(Keys.RIGHT, this::moveRight);
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return coordinate;
    }

    @Override
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.setPosition(coordinate.getX(), coordinate.getY());
        sprite.draw(spriteBatch);
    }

    @Override
    public int getPlayerId() {
        return playerId;
    }
}
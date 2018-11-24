package com.github.moribund.entity;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.images.SpriteFile;

import java.util.HashMap;
import java.util.Map;

public class Player implements PlayableCharacter {
    private Tile tile;
    private int playerId;
    private transient Sprite sprite;
    private transient Map<Integer, Runnable> keyBinds;

    public Player(int playerId) {
        this.playerId = playerId;
        sprite = MoribundClient.getInstance().getSpriteDrawer().getSprite(SpriteFile.DUMMY_PLAYER);
    }

    @Override
    public void moveUp() {
        tile = tile.transmorphY(1);
    }

    @Override
    public void moveDown() {
        tile = tile.transmorphY(-1);
    }

    @Override
    public void moveLeft() {
        tile = tile.transmorphX(-1);
    }

    @Override
    public void moveRight() {
        tile = tile.transmorphX(1);
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
    public Tile getCurrentTile() {
        return tile;
    }

    @Override
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.setPosition(tile.getX(), tile.getY());
        sprite.draw(spriteBatch);
    }

    @Override
    public int getPlayerId() {
        return playerId;
    }
}
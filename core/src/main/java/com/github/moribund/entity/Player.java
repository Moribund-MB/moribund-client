package com.github.moribund.entity;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.images.SpriteFile;
import it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class Player implements PlayableCharacter {
    private Tile tile;
    private int playerId;
    private Sprite sprite;
    private AbstractInt2ObjectMap<Runnable> keyBinds;

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
    public void bindKeys() {
        keyBinds.put(Input.Keys.UP, this::moveUp);
        keyBinds.put(Input.Keys.DOWN, this::moveDown);
        keyBinds.put(Input.Keys.RIGHT, this::moveRight);
        keyBinds.put(Input.Keys.LEFT, this:: moveLeft);
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

    @Override
    public AbstractInt2ObjectMap<Runnable> getKeyBinds() {
        if (keyBinds == null) {
            keyBinds = new Int2ObjectOpenHashMap<>();
            bindKeys();
        }
        return keyBinds;
    }

    @Override
    public void keyPressed(int keyPressed) {
        keyBinds.get(keyPressed).run();
    }
}
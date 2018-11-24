package com.github.moribund.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.images.SpriteFile;

public class Player implements PlayableCharacter {
    private Tile tile;
    private int playerId;
    private transient Sprite sprite;

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
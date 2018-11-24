package com.github.moribund.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;

public interface PlayableCharacter {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
    void bindKeys();
    Tile getCurrentTile();
    void setTile(Tile tile);
    void draw(SpriteBatch spriteBatch);
    int getPlayerId();
    AbstractInt2ObjectMap<Runnable> getKeyBinds();
    void keyPressed(int keyPressed);
}

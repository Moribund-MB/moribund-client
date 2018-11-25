package com.github.moribund.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;

import java.util.Set;

/**
 * The {@code PlayableCharacter} interface is a template
 * for a character that can be interacted with by keys. All
 * playable characters are assumed as visible and movable.
 */
public interface PlayableCharacter {
    /**
     * Binds the keys to the {@code keyBinds} using the
     * {@link com.badlogic.gdx.Input.Keys} constants to delegate
     * {@link Runnable} actions.
     */
    void bindKeys();

    /**
     * Gets the current {@link Tile} the player is on.
     * @return The {@link Tile} the player is on.
     */
    Tile getCurrentTile();

    /**
     * Sets a new {@link Tile} for the player to now currently be on.
     * @param tile The new {@link Tile} for the player.
     */
    void setTile(Tile tile);

    /**
     * Draws the player onto the screen.
     * @param spriteBatch The {@link SpriteBatch} to draw the {@code PlayableCharacter}'s
     *                    {@link com.badlogic.gdx.graphics.g2d.Sprite} to.
     */
    void draw(SpriteBatch spriteBatch);

    /**
     * Gets the player's unique ID generated by the connection.
     * @return The Player's unique ID.
     */
    int getPlayerId();

    /**
     * Gets the respective {@link com.badlogic.gdx.Input.Keys} for the above actions
     * and/or custom-defined ones.
     * @return The key binds defined by {@link PlayableCharacter#bindKeys()}.
     */
    AbstractInt2ObjectMap<Runnable> getKeyBinds();

    Set<Flag> getFlags();

    /**
     * Handles the key being pressed by a player after it has gone through
     * client-server latency.
     * @param keyPressed The {@link com.badlogic.gdx.Input.Keys} value that was
     *                   pressed.
     */
    void keyPressed(int keyPressed);
}
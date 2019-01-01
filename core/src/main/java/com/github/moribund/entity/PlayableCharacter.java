package com.github.moribund.entity;

import com.badlogic.gdx.InputProcessor;
import it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;

/**
 * The {@code PlayableCharacter} interface is a template
 * for a character that can be interacted with by keys. All
 * playable characters are assumed as visible, movable, and
 * an input processor.
 */
public abstract class PlayableCharacter implements Drawable, Movable, InputProcessor {

    /**
     * Gets the player's unique ID generated by the connection.
     * @return The Player's unique ID.
     */
    public abstract int getPlayerId();

    /**
     * Binds the keys to the {@code keyBinds} using the
     * {@link com.badlogic.gdx.Input.Keys} constants to delegate
     * {@link Runnable} actions.
     */
    public abstract void bindKeys();

    /**
     * Gets the respective {@link PlayerAction} for the
     * {@link com.badlogic.gdx.Input.Keys} value pressed.
     * @return The key binds defined by {@link PlayableCharacter#bindKeys()}.
     */
    public abstract AbstractInt2ObjectMap<PlayerAction> getKeyBinds();

    /**
     * Handles the key being pressed by a player after it has gone through
     * client-server latency.
     * @param keyPressed The {@link com.badlogic.gdx.Input.Keys} value that was
     *                   pressed.
     */
    public abstract void keyPressed(int keyPressed);

    /**
     * Handles the key being lifted by a player after it has gone through
     * client-server latency.
     * @param keyUnpressed The {@link com.badlogic.gdx.Input.Keys} value that
     *                     was lifted.
     */
    public abstract void keyUnpressed(int keyUnpressed);
}
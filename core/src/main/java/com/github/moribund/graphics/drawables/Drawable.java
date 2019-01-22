package com.github.moribund.graphics.drawables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * A {code Drawable} object is an object that has a {@link com.badlogic.gdx.graphics.g2d.Sprite} that is visible
 * to the {@link com.badlogic.gdx.Screen}.
 */
interface Drawable {
    /**
     * Draws the player onto the screen.
     * @param spriteBatch The {@link SpriteBatch} to draw the {@code PlayableCharacter}'s
     *                    {@link com.badlogic.gdx.graphics.g2d.Sprite} to.
     */
    void draw(SpriteBatch spriteBatch);
}

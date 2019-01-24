package com.github.moribund.graphics.drawables;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * A {code Drawable} object is an object that has a {@link com.badlogic.gdx.graphics.g2d.Sprite} that is visible
 * to the {@link com.badlogic.gdx.Screen}.
 */
interface Drawable {
    /**
     * Draws an asset onto the screen.
     * @param spriteBatch The {@link Batch} to draw {@link com.badlogic.gdx.graphics.g2d.Sprite}s to.
     */
    void draw(Batch spriteBatch);
}

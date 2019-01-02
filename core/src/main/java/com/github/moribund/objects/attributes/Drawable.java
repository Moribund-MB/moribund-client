package com.github.moribund.objects.attributes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Drawable {
    /**
     * Draws the player onto the screen.
     * @param spriteBatch The {@link SpriteBatch} to draw the {@code PlayableCharacter}'s
     *                    {@link com.badlogic.gdx.graphics.g2d.Sprite} to.
     */
    void draw(SpriteBatch spriteBatch);
}

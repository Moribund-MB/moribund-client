package com.github.moribund.objects.attributes;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * A {code Drawable} object is an object that has a {@link com.badlogic.gdx.graphics.g2d.Sprite} that is visible
 * to the {@link com.badlogic.gdx.Screen}. All {@code Drawable}s that wish to be displayed go to the
 * {@link com.github.moribund.MoribundClient#drawables} {@link it.unimi.dsi.fastutil.objects.ObjectList}.
 */
public interface Drawable {
    Sprite getSprite();
    /**
     * Draws the player onto the screen.
     * @param spriteBatch The {@link SpriteBatch} to draw the {@code PlayableCharacter}'s
     *                    {@link com.badlogic.gdx.graphics.g2d.Sprite} to.
     */
    void draw(SpriteBatch spriteBatch);
}

package com.github.moribund.graphics.drawables;

/**
 * A {@code DrawableGameAsset} is a game asset that is drawn with respect to the Orthographic camera.
 * The {@link com.badlogic.gdx.graphics.g2d.SpriteBatch} passed in is the
 * {@link com.github.moribund.screens.game.GameScreen#gameBatch}.
 *
 * @implNote All {@code DrawableGameAsset}s that wish to be displayed as a game asset go to
 * {@link com.github.moribund.MoribundClient#drawableGameAssets}.
 */
public interface DrawableGameAsset extends Drawable {
}

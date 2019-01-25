package com.github.moribund.graphics.drawables;

/**
 * A {@code DrawableUIAsset} is a UI asset that is drawn with respect to the client's bounds.
 * The {@link com.badlogic.gdx.graphics.g2d.SpriteBatch} passed in is the
 * {@link com.github.moribund.screens.game.GameScreen#uiBatch}.
 *
 * @implNote All {@code DrawableUIAsset}s that wish to be displayed as a UI asset go to
 * {@link com.github.moribund.MoribundClient#drawableUIAssets}.
 */
public interface DrawableUIAsset extends Drawable {
}

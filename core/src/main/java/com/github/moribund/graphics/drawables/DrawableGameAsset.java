package com.github.moribund.graphics.drawables;

import com.badlogic.gdx.math.Polygon;

/**
 * All {@link DrawableGameAsset}s that wish to be displayed as a game asset go to
 * {@link com.github.moribund.MoribundClient#drawableGameAssets}
 */
public interface DrawableGameAsset extends Drawable {
    Polygon getPolygon();
}

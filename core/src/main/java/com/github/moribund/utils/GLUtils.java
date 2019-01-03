package com.github.moribund.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import lombok.experimental.UtilityClass;

/**
 * The utility methods that aid in the usage of OpenGl.
 */
@UtilityClass
public class GLUtils {
    /**
     * Clears the GL without revealing all the magical stuff behind-the-scenes.
     */
    public void clearGL() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}

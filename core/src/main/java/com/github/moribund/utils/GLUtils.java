package com.github.moribund.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.github.moribund.graphics.fonts.FontFile;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import lombok.val;

/**
 * The utility methods that aid in the usage of OpenGl.
 */
@UtilityClass
public class GLUtils {
    @Getter(lazy = true)
    private final Texture greenTexture = new Texture(GLUtils.createProceduralPixmap(1, 1, 0, 1, 0));
    @Getter(lazy = true)
    private final Texture redTexture = new Texture(GLUtils.createProceduralPixmap(1, 1, 1, 0, 0));

    /**
     * Clears the GL without revealing all the magical stuff behind-the-scenes.
     */
    public void clearGL() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private Pixmap createProceduralPixmap(int width, int height, int r, int g, int b) {
        val pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(r, g, b, 1);
        pixmap.fill();
        return pixmap;
    }

    public BitmapFont getFont(FontFile fontFile) {
        return new BitmapFont(Gdx.files.internal(fontFile.getFontFilePath()), Gdx.files.internal(fontFile.getPngFilePath()), false);
    }
}

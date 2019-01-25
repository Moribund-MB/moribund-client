package com.github.moribund.graphics.fonts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Getter;
import lombok.val;

public class FontContainer {

    private Object2ObjectMap<FontFile, BitmapFont> fontForFile;

    /**
     * The singleton instance of this container.
     */
    @Getter(lazy = true)
    private static final FontContainer instance = new FontContainer();

    private FontContainer() {
        fontForFile = new Object2ObjectOpenHashMap<>();
    }

    public void setup() {
        for (FontFile fontFile : FontFile.VALUES) {
            val font = new BitmapFont(Gdx.files.internal(fontFile.getFontFilePath()), Gdx.files.internal(fontFile.getPngFilePath()), false);
            fontForFile.put(fontFile, font);
        }
    }

    public BitmapFont getFont(FontFile file) {
        return fontForFile.get(file);
    }
}

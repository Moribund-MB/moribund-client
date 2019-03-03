package com.github.moribund.graphics.fonts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Getter;
import lombok.val;

/**
 * The {@code FontContainer} class contains {@link BitmapFont}s.
 */
public class FontContainer {

    /**
     * A {@link Object2ObjectOpenHashMap} that contains all the {@link BitmapFont}s
     * in relation to their {@link FontFile}.
     */
    private final Object2ObjectMap<FontFile, BitmapFont> fontForFile;

    /**
     * The singleton instance of this container.
     */
    @Getter(lazy = true)
    private static final FontContainer instance = new FontContainer();

    /**
     * The constructor for the {@code FontContainer}. This initializes {@link FontContainer#fontForFile}.
     */
    private FontContainer() {
        fontForFile = new Object2ObjectOpenHashMap<>();
    }

    /**
     * Sets up the {@link FontContainer#fontForFile} looping through every
     * {@link FontFile} value and using its {@link FontFile#fontFilePath} and {@link FontFile#pngFilePath}
     * to create a {@link BitmapFont}
     */
    public void setup() {
        for (FontFile fontFile : FontFile.VALUES) {
            val font = new BitmapFont(Gdx.files.internal(fontFile.getFontFilePath()), Gdx.files.internal(fontFile.getPngFilePath()), false);
            fontForFile.put(fontFile, font);
        }
    }

    /**
     * Gets the respective {@link BitmapFont} made using the data in {@link FontFile}.
     * @param file The file field of the font.
     * @return The font of the file.
     */
    public BitmapFont getFont(FontFile file) {
        return fontForFile.get(file);
    }
}

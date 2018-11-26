package com.github.moribund.images;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.val;

/**
 * The {@code SpriteContainer} class displays {@link Sprite}s. It is set up
 * at the start of the program and populates a {@link java.util.HashMap}
 * to have readily available {@link Sprite}s.
 */
public class SpriteContainer {
    /**
     * A {@link Object2ObjectOpenHashMap} that contains all the {@link Sprite}
     * in relation to their {@link SpriteFile}. The reason to prefer a {@link Object2ObjectOpenHashMap}
     * over a {@link java.util.HashMap} is due to the superior speed of the
     * fastutil library over the standard Java ones.
     */
    private final Object2ObjectOpenHashMap<SpriteFile, Sprite> spriteForFile;
    /**
     * The singleton instance of this container.
     */
    private static SpriteContainer instance;

    /**
     * The constructor for the {@code SpriteDrawer}. This initializes {@link SpriteContainer#spriteForFile},
     * then populates it by calling {@link SpriteContainer#setup()}.
     */
    private SpriteContainer() {
        spriteForFile = new Object2ObjectOpenHashMap<>();
    }

    /**
     * Populates the {@link SpriteContainer#spriteForFile}, using
     * {@link SpriteContainer#makeSprite(SpriteFile)} to make {@link Sprite}s.
     */
    public void setup() {
        for (SpriteFile spriteFile : SpriteFile.VALUES) {
            val sprite = makeSprite(spriteFile);
            spriteForFile.put(spriteFile, sprite);
        }
    }

    /**
     * Makes a {@link Sprite} instance by the {@link SpriteFile} value using its
     * {@link SpriteFile#location} field and {@code LibGDX}'s {@link Texture}.
     * @param file The {@link SpriteFile} enum value.
     * @return The {@link Sprite} made.
     */
    private Sprite makeSprite(SpriteFile file) {
        val texture = new Texture(Gdx.files.internal(file.getLocation()));
        return new Sprite(texture);
    }

    /**
     * Gets the sprite for a given {@link SpriteFile} stored in the {@link SpriteContainer#spriteForFile}.
     * @param file The {@link SpriteFile} enum value to get.
     * @return The {@link Sprite} fetched.
     */
    public Sprite getSprite(SpriteFile file) {
        return spriteForFile.get(file);
    }

    /**
     * Gets the singleton instance or initializes it lazily if it is null.
     * @return The singleton instance of the container.
     */
    public static SpriteContainer getInstance() {
        if (instance == null) {
            instance = new SpriteContainer();
        }
        return instance;
    }
}
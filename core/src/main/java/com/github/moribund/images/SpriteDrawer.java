package com.github.moribund.images;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.entity.Coordinate;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.val;

import javax.inject.Inject;

/**
 * The {@code SpriteDrawer} class displays {@link Sprite}s. It is set up
 * at the start of the program and populates a {@link java.util.HashMap}
 * to have readily available {@link Sprite} that can then be displayed
 * directly from this class. The use of Dagger 2's {@link Inject}ion
 * allows much more easy to simply using this {@code SpriteDrawer} as opposed
 * to having to make one's own {@link SpriteBatch} field.
 */
public class SpriteDrawer {
    /**
     * A {@link Object2ObjectOpenHashMap} that contains all the {@link Sprite}
     * in relation to their {@link SpriteFile}. The reason to prefer a {@link Object2ObjectOpenHashMap}
     * over a {@link java.util.HashMap} can be found in {@link com.github.moribund.audio.MusicPlayer#musicForFile}'s
     * documentation.
     */
    private final Object2ObjectOpenHashMap<SpriteFile, Sprite> spriteForFile;
    /**
     * The {@link SpriteBatch} that is {@link Inject}ed by Dagger 2.
     */
    @Inject
    SpriteBatch spriteBatch;

    /**
     * The constructor for the {@code SpriteDrawer}. This injects the {@link SpriteComponent},
     * initializes {@link SpriteDrawer#spriteForFile}, then populates it by calling
     * {@link SpriteDrawer#setup()}.
     */
    public SpriteDrawer() {
        injectSpriteComponenet();
        spriteForFile = new Object2ObjectOpenHashMap<>();
        setup();
    }

    /**
     * Injects the {@code SpriteDrawer} to provide a {@link SpriteDrawer#spriteBatch}.
     */
    private void injectSpriteComponenet() {
        MoribundClient.getInstance().getSpriteComponent().inject(this);
    }

    /**
     * Populates the {@link SpriteDrawer#spriteForFile}, using
     * {@link SpriteDrawer#makeSprite(SpriteFile)} to make {@link Sprite}s.
     */
    private void setup() {
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
        return new Sprite(texture, 0, 0, texture.getWidth(), texture.getHeight());
    }

    /**
     * Draws a {@link Sprite} by fetching it from the {@link SpriteDrawer#spriteForFile}
     * {@link java.util.HashMap} and drawing it to the given {@link Coordinate}.
     * @param spriteFile The {@link SpriteFile} enum value to draw.
     * @param coordinate The {@link Coordinate} on the game's grid.
     */
    public void drawSprite(SpriteFile spriteFile, Coordinate coordinate) {
        val sprite = getSprite(spriteFile);
        sprite.setPosition(coordinate.getX(), coordinate.getY());
        sprite.draw(spriteBatch);
    }

    /**
     * Gets the sprite for a given {@link SpriteFile} stored in the {@link SpriteDrawer#spriteForFile}.
     * @param file The {@link SpriteFile} enum value to get.
     * @return The {@link Sprite} fetched.
     */
    private Sprite getSprite(SpriteFile file) {
        return spriteForFile.get(file);
    }
}

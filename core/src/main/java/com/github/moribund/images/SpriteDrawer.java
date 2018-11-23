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

public class SpriteDrawer {
    private final Object2ObjectOpenHashMap<SpriteFile, Sprite> spriteForFile;
    @Inject
    SpriteBatch spriteBatch;

    public SpriteDrawer() {
        MoribundClient.getInstance().getSpriteComponent().inject(this);
        spriteForFile = new Object2ObjectOpenHashMap<>();
        setup();
    }

    private void setup() {
        for (SpriteFile spriteFile : SpriteFile.VALUES) {
            val sprite = makeSprite(spriteFile);
            spriteForFile.put(spriteFile, sprite);
        }
    }

    private Sprite makeSprite(SpriteFile file) {
        val texture = new Texture(Gdx.files.internal(file.getLocation()));
        return new Sprite(texture, 0, 0, texture.getWidth(), texture.getHeight());
    }

    public void drawSprite(SpriteFile spriteFile, Coordinate coordinate) {
        val sprite = getSprite(spriteFile);
        sprite.setPosition(coordinate.getX(), coordinate.getY());
        sprite.draw(spriteBatch);
    }

    public Sprite getSprite(SpriteFile file) {
        return spriteForFile.get(file);
    }
}

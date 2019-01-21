package com.github.moribund.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Getter;
import lombok.val;

public class AnimationContainer {
    private Object2ObjectMap<AnimationFile, SpriteAnimation> animationForFile;

    /**
     * The singleton instance of this container.
     */
    @Getter(lazy = true)
    private static final AnimationContainer instance = new AnimationContainer();

    private AnimationContainer() {
        animationForFile = new Object2ObjectOpenHashMap<>();
    }

    public void setup() {
        for (AnimationFile animationFile : AnimationFile.VALUES) {
            val animation = makeAnimation(animationFile);
            animationForFile.put(animationFile, animation);
        }
    }

    private SpriteAnimation makeAnimation(AnimationFile animationFile) {
        val texture = new Texture(Gdx.files.internal(animationFile.getFile()));
        TextureRegion[][] splitRegions = TextureRegion.split(texture,
                texture.getWidth() / animationFile.getFrameColumns(),
                texture.getHeight() / animationFile.getFrameRows());
        TextureRegion[] frames = new TextureRegion[animationFile.getFrameColumns() * animationFile.getFrameRows()];
        int index = 0;
        for (int i = 0; i < animationFile.getFrameRows(); i++) {
            for (int j = 0; j < animationFile.getFrameColumns(); j++) {
                frames[index++] = splitRegions[i][j];
            }
        }
        return new SpriteAnimation(animationFile.getDuration(), frames);
    }

    public SpriteAnimation getAnimation(AnimationFile file) {
        return animationForFile.get(file);
    }
}

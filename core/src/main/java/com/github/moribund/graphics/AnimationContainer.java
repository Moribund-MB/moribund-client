package com.github.moribund.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
        val atlas = new TextureAtlas(Gdx.files.internal(animationFile.getFile()));
        return new SpriteAnimation(animationFile.getDuration(), atlas.findRegions(animationFile.getRegionName()));
    }

    public SpriteAnimation getAnimation(AnimationFile file) {
        return animationForFile.get(file);
    }
}

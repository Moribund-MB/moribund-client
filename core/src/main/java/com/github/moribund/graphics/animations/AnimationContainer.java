package com.github.moribund.graphics.animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Getter;
import lombok.val;

/**
 * The {@code AnimationContainer} class contains {@link SpriteAnimation}s.
 */
public class AnimationContainer {

    /**
     * A {@link Object2ObjectOpenHashMap} that contains all the {@link SpriteAnimation}
     * in relation to their {@link AnimationFile}. The reason to prefer a {@link Object2ObjectOpenHashMap}
     * over a {@link java.util.HashMap} is due to {@code fastutil}'s superior efficiency
     * compared to vanilla Java's.
     */
    private final Object2ObjectMap<AnimationFile, SpriteAnimation> animationForFile;

    /**
     * The singleton instance of this container.
     */
    @Getter(lazy = true)
    private static final AnimationContainer instance = new AnimationContainer();

    /**
     * The constructor for the {@code AnimationContainer}. This initializes {@link AnimationContainer#animationForFile}.
     */
    private AnimationContainer() {
        animationForFile = new Object2ObjectOpenHashMap<>();
    }

    /**
     * Sets up the {@link AnimationContainer#animationForFile} looping through every
     * {@link AnimationFile} value and using its {@link AnimationFile#getFile()} field and
     * calling {@link AnimationContainer}
     */
    public void setup() {
        for (AnimationFile animationFile : AnimationFile.VALUES) {
            val animation = makeAnimation(animationFile);
            animationForFile.put(animationFile, animation);
        }
    }

    /**
     * Makes an animation using the {@link AnimationFile}'s atlas file.
     * @param animationFile The respective animation file to make an animation from.
     * @return The newly made {@link SpriteAnimation}.
     */
    private SpriteAnimation makeAnimation(AnimationFile animationFile) {
        val atlas = new TextureAtlas(Gdx.files.internal(animationFile.getFile()));
        return new SpriteAnimation(animationFile.getDuration(), atlas.findRegions(animationFile.getRegionName()));
    }

    /**
     * Gets an {@link SpriteAnimation} from the animation hashmap.
     * @param file The file to fetch the animation of.
     * @return The respective file's animation.
     */
    public SpriteAnimation getAnimation(AnimationFile file) {
        return animationForFile.get(file);
    }
}

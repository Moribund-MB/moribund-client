package com.github.moribund.graphics.animations;

import lombok.Getter;

/**
 * The {@code AnimationFile} points to the {@link com.badlogic.gdx.graphics.g2d.TextureAtlas} location of
 * an animation.
 */
public enum AnimationFile {
    /**
     * The texture atlas of the bow animation.
     */
    BOW("images/players/animations/bow_animation.atlas", "Bow", 0.15f),

    /**
     * The texture atlas of the dart animation.
     */
    DART("images/players/animations/dart_animation.atlas", "Dart", 0.1f),

    /**
     * The texture atlas of the spear animation.
     */
    SPEAR("images/players/animations/spear_animation.atlas", "Spear", 0.2f),
    ;

    /**
     * All the values of the AnimationFile enum. This field is here to save memory, as {@link Animation#values()} won't
     * need to be invoked to make an array.
     */
    public static final AnimationFile[] VALUES = values();

    /**
     * The location of the texture atlas.
     */
    @Getter
    private final String file;

    /**
     * The region name of the texture requested.
     */
    @Getter
    private final String regionName;

    /**
     * The duration of the animation.
     */
    @Getter
    private final float duration;

    AnimationFile(String file, String regionName, float duration) {
        this.file = file;
        this.regionName = regionName;
        this.duration = duration;
    }
}

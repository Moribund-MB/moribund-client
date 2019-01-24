package com.github.moribund.graphics;

import lombok.Getter;

/**
 * An animation is an ID that is related to its respective animation file.
 *
 * TODO convert this enum to a publicly static HashMap for a faster Big(O) speed.
 */
public enum Animation {
    /**
     * The animation for a player shooting a bow.
     */
    BOW(0, AnimationFile.BOW),

    /**
     * The animation for a player throwing a dart.
     */
    DART(1, AnimationFile.DART),

    /**
     * The animation for a player throwing a spear.
     */
    SPEAR(2, AnimationFile.SPEAR);

    /**
     * All the values of the Animation enum This field is here to save memory, as {@link Animation#values()} won't
     * need to be invoked to make an array.
     */
    private static final Animation[] VALUES = values();

    /**
     * The ID of the animation.
     */
    private final int id;

    /**
     * The respective {@link AnimationFile} for the {@code Animation}.
     */
    @Getter
    private final AnimationFile file;

    Animation(int id, AnimationFile file) {
        this.id = id;
        this.file = file;
    }

    /**
     * Gets an {@code Animation} based on it's {@link Animation#id}.
     * @param id The ID of the {@code Animation} to find.
     * @return The {@code Animation} found, which returns null should the animation not be found.
     */
    public static Animation getForId(int id) {
        for (Animation animation : VALUES) {
            if (animation.id == id) {
                return animation;
            }
        }
        return null;
    }
}

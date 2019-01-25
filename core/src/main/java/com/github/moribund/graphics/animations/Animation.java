package com.github.moribund.graphics.animations;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.Getter;

/**
 * An animation as an ID that is related to its respective animation file.
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
     * All the values of the Animation enum associated with their animation ID.
     */
    private static final Int2ObjectMap<Animation> VALUES;

    /**
     * The ID of the animation.
     */
    private final int id;

    /**
     * The respective {@link AnimationFile} for the {@code Animation}.
     */
    @Getter
    private final AnimationFile file;

    static {
        VALUES = new Int2ObjectOpenHashMap<>();
        for (Animation animation : values()) {
            VALUES.put(animation.id, animation);
        }
    }

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
        return VALUES.get(id);
    }
}

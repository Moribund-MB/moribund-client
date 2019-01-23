package com.github.moribund.graphics;

import lombok.Getter;

public enum Animation {
    BOW(0, AnimationFile.BOW),
    DART(1, AnimationFile.DART),
    SPEAR(2, AnimationFile.SPEAR);

    private static final Animation[] VALUES = values();

    private final int id;
    @Getter
    private final AnimationFile file;

    Animation(int id, AnimationFile file) {
        this.id = id;
        this.file = file;
    }

    public static Animation getForId(int id) {
        for (Animation animation : VALUES) {
            if (animation.id == id) {
                return animation;
            }
        }
        return null;
    }
}

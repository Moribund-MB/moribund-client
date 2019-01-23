package com.github.moribund.graphics;

import lombok.Getter;

public enum AnimationFile {
    BOW("images/players/animations/bow_animation.atlas", "Bow", 0.2f),
    DART("images/players/animations/dart_animation.atlas", "Dart", 0.1f),
    SPEAR("images/players/animations/spear_animation.atlas", "Spear", 0.1f),
    ;

    public static final AnimationFile[] VALUES = values();

    @Getter
    private final String file;
    @Getter
    private final String regionName;
    @Getter
    private final float duration;

    AnimationFile(String file, String regionName, float duration) {
        this.file = file;
        this.regionName = regionName;
        this.duration = duration;
    }
}

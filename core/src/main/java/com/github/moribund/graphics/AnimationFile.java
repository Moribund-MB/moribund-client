package com.github.moribund.graphics;

import lombok.Getter;

public enum AnimationFile {
    BOW("images/players/animations/bow_animation.png", 5, 1, 0.2f),
    DART("images/players/animations/dart_animation.png", 7, 1, 0.1f),
    SPEAR("images/players/animations/spear_animation.png", 6, 1, 0.1f),
    ;

    public static final AnimationFile[] VALUES = values();

    @Getter
    private final String file;
    @Getter
    private final int frameColumns;
    @Getter
    private final int frameRows;
    @Getter
    private final float duration;

    AnimationFile(String file, int frameColumns, int frameRows, float duration) {
        this.file = file;
        this.frameColumns = frameColumns;
        this.frameRows = frameRows;
        this.duration = duration;
    }
}

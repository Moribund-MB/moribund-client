package com.github.moribund.graphics;

import lombok.Getter;

public enum AnimationFile {
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

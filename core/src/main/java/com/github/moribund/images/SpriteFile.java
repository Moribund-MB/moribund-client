package com.github.moribund.images;

import lombok.Getter;

public enum SpriteFile {
    DUMMY_PLAYER("images/player.png");

    public static final SpriteFile[] VALUES = values();

    @Getter
    private final String location;

    SpriteFile(String location) {
        this.location = location;
    }
}

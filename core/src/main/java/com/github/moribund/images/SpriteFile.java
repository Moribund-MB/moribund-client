package com.github.moribund.images;

import lombok.Getter;

/**
 * A {@code SpriteFile} that represents a location for a certain sprite.
 */
public enum SpriteFile {
    /**
     * A dummy player character.
     */
    DUMMY_PLAYER("images/player.png");

    /**
     * A static, final singleton for the {@link SpriteFile#values()} method so
     * that it does not constantly build a new array of values.
     */
    static final SpriteFile[] VALUES = values();

    /**
     * The location of the file related to this particular value.
     */
    @Getter
    private final String location;

    /**
     * Constructor for a {@code SpriteFile} enum value.
     * @param location The location of the file.
     */
    SpriteFile(String location) {
        this.location = location;
    }
}

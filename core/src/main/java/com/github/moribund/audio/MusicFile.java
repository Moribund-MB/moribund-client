package com.github.moribund.audio;

import lombok.Getter;

/**
 * A {@code MusicFile} that represents a location for a certain music file based on
 * the title given by the value name.
 */
public enum MusicFile {
    /**
     * The title screen song.
     */
    TITLE_SCREEN("music/title.mp3");

    /**
     * A static, final singleton for the {@link MusicFile#values()} method so
     * that it does not constantly build a new array of values.
     */
    static final MusicFile[] VALUES = values();

    /**
     * The location of the file related to this particular value.
     */
    @Getter
    private final String location;

    /**
     * Constructor for a {@code MusicFile} enum value.
     * @param location The location of the file.
     */
    MusicFile(String location) {
        this.location = location;
    }
}

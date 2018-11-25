package com.github.moribund.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.val;

/**
 * The {@code MusicContainer} class contains {@link MusicFile}s. The music
 * is populated lazily.
 */
public class MusicContainer {
    /**
     * A {@link Object2ObjectOpenHashMap} that contains all the {@link Music}
     * in relation to their {@link MusicFile}. The reason to prefer a {@link Object2ObjectOpenHashMap}
     * over a {@link java.util.HashMap} is due to {@code fastutil}'s superior efficiency
     * compared to vanilla Java's.
     */
    private final Object2ObjectOpenHashMap<MusicFile, Music> musicForFile;
    /**
     * The singleton instance of this container.
     */
    private static MusicContainer instance;

    /**
     * The constructor for the {@code MusicContainer}. This initializes {@link MusicContainer#musicForFile},
     * then populates it by calling {@link MusicContainer#setup()}.
     */
    private MusicContainer() {
        musicForFile = new Object2ObjectOpenHashMap<>();
        setup();
    }

    /**
     * Sets up the {@link MusicContainer#musicForFile} looping through every
     * {@link MusicFile} value and using its {@link MusicFile#location} field and
     * {@code LibGDX}'s {@link com.badlogic.gdx.Audio} class to make a new {@link Music} instance.
     */
    private void setup() {
        for (MusicFile musicFile : MusicFile.VALUES) {
            val music = Gdx.audio.newMusic(Gdx.files.internal(musicFile.getLocation()));
            musicForFile.put(musicFile, music);
        }
    }

    /**
     * Gets a music for the file given.
     * @param musicFile The music track to play.
     * @return The music for the track.
     */
    public Music getMusic(MusicFile musicFile) {
        return musicForFile.get(musicFile);
    }

    /**
     * Gets the singleton instance or initializes it lazily if it is null.
     * @return The singleton instance of the container.
     */
    public static MusicContainer getInstance() {
        if (instance == null) {
            instance = new MusicContainer();
        }
        return instance;
    }
}

package com.github.moribund.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.val;

/**
 * The {@code MusicContainer} class plays {@link MusicFile}s. It is set up
 * at the start of the program and populates a {@link java.util.HashMap}
 * to have readily available {@link Music}.
 */
public class MusicContainer {
    /**
     * A {@link Object2ObjectOpenHashMap} that contains all the {@link Music}
     * in relation to their {@link MusicFile}. The reason to prefer a {@link Object2ObjectOpenHashMap}
     * over a {@link java.util.HashMap} is due to {@code fastutil}'s superior efficiency
     * compared to vanilla Java's.
     */
    private final Object2ObjectOpenHashMap<MusicFile, Music> musicForFile;
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

    public Music getMusic(MusicFile musicFile) {
        return musicForFile.get(musicFile);
    }

    public static MusicContainer getInstance() {
        if (instance == null) {
            instance = new MusicContainer();
        }
        return instance;
    }
}

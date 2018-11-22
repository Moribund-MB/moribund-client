package com.github.moribund.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.val;

/**
 * The {@code MusicPlayer} class plays {@link MusicFile}s. It is set up
 * at the start of the program and populates a {@link java.util.HashMap}
 * to have readily available {@link Music}.
 */
public class MusicPlayer {
    /**
     * A {@link Object2ObjectOpenHashMap} that contains all the {@link Music}
     * in relation to their {@link MusicFile}. The reason to prefer a {@link Object2ObjectOpenHashMap}
     * over a {@link java.util.HashMap} is due to {@code fastutil}'s superior efficiency
     * compared to vanilla Java's.
     */
    private final Object2ObjectOpenHashMap<MusicFile, Music> musicForFile;

    /**
     * The constructor for the {@code MusicPlayer}. This initializes {@link MusicPlayer#musicForFile},
     * then populates it by calling {@link MusicPlayer#setup()}.
     */
    public MusicPlayer() {
        musicForFile = new Object2ObjectOpenHashMap<>();
        setup();
    }

    /**
     * Sets up the {@link MusicPlayer#musicForFile} looping through every
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
     * Plays a given {@link MusicFile}.
     * @param musicFile The {@link MusicFile} to play.
     * @param looping If this {@link Music} will loop or not.
     */
    public void play(MusicFile musicFile, boolean looping) {
        val music = musicForFile.get(musicFile);
        music.setLooping(looping);
        music.play();
    }

    /**
     * Disposes of all the {@link Music} in {@link MusicPlayer#musicForFile}
     * and then clears the {@link java.util.HashMap} containing all the music.
     */
    public void dispose() {
        musicForFile.values().forEach(Music::dispose);
        musicForFile.clear();
    }
}

package com.github.moribund;

import com.badlogic.gdx.Game;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.net.NetworkBootstrapper;
import lombok.Getter;
import lombok.val;

/**
 * The {@code MoribundClient} class represents the entire {@link Game} for
 * both graphics and networking.
 */
public class MoribundClient extends Game {
    /**
     * The music player dependency.
     */
    @Getter
    private MusicPlayer musicPlayer;

    /**
     * Sets the visual graphics to its initial state and starts the client
     * to server connection.
     */
    @Override
    public void create() {
        val networkBootstrapper = new NetworkBootstrapper();
        musicPlayer = new MusicPlayer();

        setScreen(new TitleScreen(this));
        networkBootstrapper.connect();
    }

    /**
     * Cleans up all the client for optimal performance after the termination
     * of the game.
     */
    @Override
    public void dispose() {
        super.dispose();
        musicPlayer.dispose();
    }
}
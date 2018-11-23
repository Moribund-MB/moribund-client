package com.github.moribund;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.audio.DaggerMusicComponent;
import com.github.moribund.audio.MusicComponent;
import com.github.moribund.images.DaggerSpriteComponent;
import com.github.moribund.images.SpriteComponent;
import com.github.moribund.net.NetworkBootstrapper;
import lombok.Getter;
import lombok.val;

/**
 * The {@code MoribundClient} class represents the entire {@link Game} for
 * both graphics and networking.
 */
public class MoribundClient extends Game {
    private static MoribundClient instance;
    @Getter
    private SpriteBatch spriteBatch;
    @Getter
    private OrthographicCamera camera;
    @Getter
    private MusicComponent musicComponent = DaggerMusicComponent.create();
    @Getter
    private SpriteComponent spriteComponent = DaggerSpriteComponent.create();

    /**
     * Sets the visual graphics to its initial state and starts the client
     * to server connection.
     */
    @Override
    public void create() {
        instance = this;

        initializeCamera();
        initializeSpriteBatch();
        connectNetworkBootstrapper();

        setScreen(new TitleScreen());
    }

    private void initializeSpriteBatch() {
        spriteBatch = new SpriteBatch();
    }

    private void initializeCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    private void connectNetworkBootstrapper() {
        val networkBootstrapper = new NetworkBootstrapper();

//        networkBootstrapper.connect();
    }

    /**
     * Cleans up all the client for optimal performance after the termination
     * of the game.
     */
    @Override
    public void dispose() {
        super.dispose();
        musicComponent.getMusicPlayer().dispose();
        spriteBatch.dispose();
    }

    public static MoribundClient getInstance() {
        return instance;
    }
}
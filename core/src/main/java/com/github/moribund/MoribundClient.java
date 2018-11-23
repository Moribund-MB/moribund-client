package com.github.moribund;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.images.SpriteDrawer;
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
    private MusicPlayer musicPlayer;
    @Getter
    private SpriteDrawer spriteDrawer;

    /**
     * Sets the visual graphics to its initial state and starts the client
     * to server connection.
     */
    @Override
    public void create() {
        instance = this;
        initializeCamera();
        initializeSpriteBatch();
        initializeMusicPlayer();
        initializeSpriteDrawer();
        connectNetworkBootstrapper();

        setScreen(new TitleScreen());
    }

    private void initializeSpriteDrawer() {
        spriteDrawer = new SpriteDrawer();
    }

    private void initializeMusicPlayer() {
        musicPlayer = new MusicPlayer();
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
        spriteBatch.dispose();
    }

    public static MoribundClient getInstance() {
        return instance;
    }
}
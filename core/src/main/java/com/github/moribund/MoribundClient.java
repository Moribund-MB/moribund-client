package com.github.moribund;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.entity.PlayableCharacter;
import com.github.moribund.images.SpriteDrawer;
import com.github.moribund.net.NetworkBootstrapper;
import com.github.moribund.net.PacketDispatcher;
import com.github.moribund.util.Reference;
import it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
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
    @Getter
    private AbstractInt2ObjectMap<PlayableCharacter> players;
    private Reference<PacketDispatcher> packetDispatcherReference;

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
        initializePlayersMap();
        setupNetworking();

        setScreen(new TitleScreen());
    }

    private void initializePlayersMap() {
        players = new Int2ObjectOpenHashMap<>();
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

    private void setupNetworking() {
        val networkBootstrapper = new NetworkBootstrapper();
        networkBootstrapper.connect();
        packetDispatcherReference = new Reference<>();
        networkBootstrapper.initializePacketDispatcher(packetDispatcherReference);
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

    public PacketDispatcher getPacketDispatcher() {
        return packetDispatcherReference.getVariable();
    }
}
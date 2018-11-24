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
    /**
     * The singleton instance of the client for all classes to access.
     */
    private static MoribundClient instance;
    /**
     * The sprite batch of the client.
     */
    @Getter
    private SpriteBatch spriteBatch;
    /**
     * The camera shared between all screens.
     */
    @Getter
    private OrthographicCamera camera;
    /**
     * The universal music player.
     */
    @Getter
    private MusicPlayer musicPlayer;
    /**
     * The universal sprite drawer.
     */
    @Getter
    private SpriteDrawer spriteDrawer;
    /**
     * All the {@link PlayableCharacter}s in the game.
     */
    @Getter
    private AbstractInt2ObjectMap<PlayableCharacter> players;
    /**
     * The packet dispatcher to send packets to the server restrictively.
     */
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

    /**
     * Initializes the map of players.
     */
    private void initializePlayersMap() {
        players = new Int2ObjectOpenHashMap<>();
    }

    /**
     * Initializes the sprite drawer.
     */
    private void initializeSpriteDrawer() {
        spriteDrawer = new SpriteDrawer();
    }

    /**
     * Initializes the music player.
     */
    private void initializeMusicPlayer() {
        musicPlayer = new MusicPlayer();
    }

    /**
     * Initializes the sprite batch.
     */
    private void initializeSpriteBatch() {
        spriteBatch = new SpriteBatch();
    }

    /**
     * Initialzies the shared camera.
     */
    private void initializeCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    /**
     * Sets up the client to server connection.
     */
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

    /**
     * Gets the singleton instance of the client.
     * @return The singleton instance.
     */
    public static MoribundClient getInstance() {
        return instance;
    }

    /**
     * Gets the value of the pass-by-reference variable of {@link MoribundClient#packetDispatcherReference}.
     * @return The packet dispatcher to securely send packets to the server.
     */
    public PacketDispatcher getPacketDispatcher() {
        return packetDispatcherReference.getVariable();
    }
}
package com.github.moribund;

import com.badlogic.gdx.Game;
import com.github.moribund.entity.PlayableCharacter;
import com.github.moribund.net.NetworkBootstrapper;
import com.github.moribund.net.PacketDispatcher;
import com.github.moribund.screens.title.TitleScreenFactory;
import com.github.moribund.util.Reference;
import it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.Getter;
import lombok.Setter;
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
    private TitleScreenFactory titleScreenFactory;
    /**
     * All the {@link PlayableCharacter}s in the game.
     */
    @Getter
    private AbstractInt2ObjectMap<PlayableCharacter> players;
    @Getter @Setter
    private PlayableCharacter player;
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
        initializePlayersMap();
        initializeTitleScreenFactory();
        setupNetworking();

        setScreen(titleScreenFactory.createScreen());
    }

    private void initializeTitleScreenFactory() {
        titleScreenFactory = new TitleScreenFactory();
    }

    /**
     * Initializes the map of players.
     */
    private void initializePlayersMap() {
        players = new Int2ObjectOpenHashMap<>();
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
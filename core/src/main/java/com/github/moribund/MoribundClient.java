package com.github.moribund;

import com.badlogic.gdx.Game;
import com.github.moribund.entity.PlayableCharacter;
import com.github.moribund.net.NetworkBootstrapper;
import com.github.moribund.net.PacketDispatcher;
import com.github.moribund.screens.ScreenFactory;
import it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;
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

    /**
     * All the {@link PlayableCharacter}s in the game.
     */
    @Getter
    private final AbstractInt2ObjectMap<PlayableCharacter> players;
    private final ScreenFactory titleScreenFactory;
    private final NetworkBootstrapper networkBootstrapper;
    private final PacketDispatcher packetDispatcher;
    @Getter @Setter
    private PlayableCharacter player;

    MoribundClient(AbstractInt2ObjectMap<PlayableCharacter> players,
                           NetworkBootstrapper networkBootstrapper,
                           PacketDispatcher packetDispatcher,
                           ScreenFactory titleScreenFactory) {
        this.players = players;
        this.networkBootstrapper = networkBootstrapper;
        this.packetDispatcher = packetDispatcher;
        this.titleScreenFactory = titleScreenFactory;
    }

    /**
     * Sets the visual graphics to its initial state and starts the client
     * to server connection.
     */
    @Override
    public void create() {
        connectNetworking();
        setScreen(titleScreenFactory.createScreen());
    }

    /**
     * Sets up the client to server connection.
     */
    private void connectNetworking() {
        val networkBootstrapper = new NetworkBootstrapper();
        networkBootstrapper.connect();
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
        if (instance == null) {
            val moribundClientFactory = new MoribundClientFactory();
            instance = moribundClientFactory.createMoribundClient();
        }
        return instance;
    }

    public PacketDispatcher getPacketDispatcher() {
        return packetDispatcher;
    }
}
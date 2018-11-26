package com.github.moribund;

import com.badlogic.gdx.Game;
import com.github.moribund.audio.MusicContainer;
import com.github.moribund.entity.PlayableCharacter;
import com.github.moribund.images.SpriteContainer;
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
    /**
     * The factory to make the title screen.
     */
    private final ScreenFactory titleScreenFactory;
    /**
     * The network bootstrapper to start networking.
     */
    private final NetworkBootstrapper networkBootstrapper;
    /**
     * The dispatcher to send packets to the server.
     */
    private final PacketDispatcher packetDispatcher;
    /**
     * The {@link PlayableCharacter} that the user of this client is.
     */
    @Getter @Setter
    private PlayableCharacter player;

    /**
     * Constructor that provides the {@code MoribundClient} its dependencies.
     * @param players The list of players in the entire game.
     * @param networkBootstrapper The network bootstrapper to start networking.
     * @param packetDispatcher The packet dispatcher to send the server packets.
     * @param titleScreenFactory The screen factory to create the title screen.
     */
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
     * Instantiates the {@link SpriteContainer} and {@link MusicContainer},
     * connects us to the {@link com.esotericsoftware.kryonet.Server}, then
     * sets the screen to the {@link com.github.moribund.screens.title.TitleScreen}.
     */
    @Override
    public void create() {
        connectNetworking();
        SpriteContainer.getInstance().setup();
        MusicContainer.getInstance().setup();
        setScreen(titleScreenFactory.createScreen());
    }

    /**
     * Connects the client to the {@link com.esotericsoftware.kryonet.Server}.
     */
    private void connectNetworking() {
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

    /**
     * Gets the packet dispatcher.
     * @return The packet dispatcher.
     */
    public PacketDispatcher getPacketDispatcher() {
        return packetDispatcher;
    }
}
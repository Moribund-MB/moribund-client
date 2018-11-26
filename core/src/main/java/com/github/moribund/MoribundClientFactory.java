package com.github.moribund;

import com.github.moribund.entity.PlayableCharacter;
import com.github.moribund.net.NetworkBootstrapper;
import com.github.moribund.net.PacketDispatcher;
import com.github.moribund.screens.ScreenFactory;
import com.github.moribund.screens.title.TitleScreenFactory;
import it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.val;

/**
 * The factory that produces the {@link MoribundClient} and all of its dependencies.
 */
class MoribundClientFactory {

    /**
     * Creates the {@link MoribundClient} and all of its dependencies.
     * @return The newly made {@link MoribundClient}.
     */
    MoribundClient createMoribundClient() {
        val players = createPlayersMap();
        val networkBootstrapper = createNetworkBootstrapper();
        val packetDispatcher = createPacketDispatcher(networkBootstrapper);
        val titleScreenFactory = createTitleScreenFactory();
        return new MoribundClient(players, networkBootstrapper, packetDispatcher, titleScreenFactory);
    }

    /**
     * Creates the screen factory to make the title screen.
     * @return The newly made factory.
     */
    private ScreenFactory createTitleScreenFactory() {
        return new TitleScreenFactory();
    }

    /**
     * Creates the packet dispatcher using the network bootstrapper.
     * @param networkBootstrapper The network bootstrapper that contains the KryoNet connection client.
     * @return The newly created packet dispatcher that is made in the {@link NetworkBootstrapper}.
     */
    private PacketDispatcher createPacketDispatcher(NetworkBootstrapper networkBootstrapper) {
        return networkBootstrapper.createPacketDispatcher();
    }

    /**
     * Creates a network bootstrapper.
     * @return The newly made network bootstrapper.
     */
    private NetworkBootstrapper createNetworkBootstrapper() {
        return new NetworkBootstrapper();
    }

    /**
     * Creates an empty map of all the players in the game.
     * @return The newly made empty map of players.
     */
    private AbstractInt2ObjectMap<PlayableCharacter> createPlayersMap() {
        return new Int2ObjectOpenHashMap<>();
    }
}

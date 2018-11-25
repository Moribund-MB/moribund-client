package com.github.moribund;

import com.github.moribund.entity.PlayableCharacter;
import com.github.moribund.net.NetworkBootstrapper;
import com.github.moribund.net.PacketDispatcher;
import com.github.moribund.screens.ScreenFactory;
import com.github.moribund.screens.title.TitleScreenFactory;
import it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.val;

class MoribundClientFactory {
    MoribundClient createMoribundClient() {
        val players = createPlayersMap();
        val networkBootstrapper = createNetworkBootstrapper();
        val packetDispatcher = createPacketDispatcher(networkBootstrapper);
        val titleScreenFactory = createTitleScreenFactory();
        return new MoribundClient(players, networkBootstrapper, packetDispatcher, titleScreenFactory);
    }

    private ScreenFactory createTitleScreenFactory() {
        return new TitleScreenFactory();
    }

    private PacketDispatcher createPacketDispatcher(NetworkBootstrapper networkBootstrapper) {
        return networkBootstrapper.getPacketDispatcher();
    }

    private NetworkBootstrapper createNetworkBootstrapper() {
        return new NetworkBootstrapper();
    }

    private AbstractInt2ObjectMap<PlayableCharacter> createPlayersMap() {
        return new Int2ObjectOpenHashMap<>();
    }
}

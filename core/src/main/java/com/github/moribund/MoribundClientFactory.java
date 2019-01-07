package com.github.moribund;

import com.github.moribund.net.NetworkBootstrapper;
import com.github.moribund.net.PacketDispatcher;
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
        val networkBootstrapper = createNetworkBootstrapper();
        val packetDispatcher = createPacketDispatcher(networkBootstrapper);
        return new MoribundClient(networkBootstrapper, packetDispatcher);
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
}

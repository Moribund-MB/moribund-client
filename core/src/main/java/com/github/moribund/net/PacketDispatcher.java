package com.github.moribund.net;

import com.esotericsoftware.kryonet.Client;
import com.github.moribund.net.packets.OutgoingPacket;

/**
 * The {@code PacketDispatcher} class is responsible for {@link Client}
 * to {@link com.esotericsoftware.kryonet.Server} sending of packets. It
 * provides a restrictive access to the {@link Client} to the public classes.
 */
public class PacketDispatcher {
    /**
     * The connection client.
     */
    private final Client client;

    /**
     * This constructor to initialize the connection client for restrictive access.
     * @param client The client to be accessed for packet dispatching.
     */
    PacketDispatcher(Client client) {
        this.client = client;
    }

    /**
     * Sends a UDP packet to the server. With the server now having a game state
     * (see {@link com.github.moribund.net.packets.game.GameStatePacket}), UDP is
     * now optimal as, though packets may be lost, it requires less overhead.
     * @param packet The {@link OutgoingPacket} packet. See the documentation for {@link OutgoingPacket}s for more
     *               details.
     */
    public void sendUDP(OutgoingPacket packet){
        client.sendUDP(packet);
    }
}

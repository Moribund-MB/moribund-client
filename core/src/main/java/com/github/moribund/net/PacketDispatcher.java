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
     * Sends a UDP packet to the server. An example of a packet using UDP is
     * (see {@link com.github.moribund.net.packets.game.GameStatePacket})
     * @param packet The {@link OutgoingPacket} packet. See the documentation for {@link OutgoingPacket}s for more
     *               details.
     */
    public void sendUDP(OutgoingPacket packet){
        client.sendUDP(packet);
    }

    /**
     * Sends a TCP packet to the server. TCP is preferred for one-time sent data.
     * @param packet The {@link OutgoingPacket} packet. See the documentation for {@link OutgoingPacket}s for more
     *               details.
     */
    public void sendTCP(OutgoingPacket packet){
        client.sendTCP(packet);
    }
}

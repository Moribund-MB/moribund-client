package com.github.moribund.net;

import com.esotericsoftware.kryonet.Client;
import com.github.moribund.net.packets.Packet;

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
     * Sends a {@link Packet} through TCP.
     * @param packet The {@link Packet} to send.
     */
    public void sendTCP(Packet packet) {
        client.sendTCP(packet);
    }
}

package com.github.moribund.net;

import com.esotericsoftware.kryonet.Client;

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
     * Sends an {@link Object} through TCP.
     * @param object The {@link Object}, or packet, to send.
     * @apiNote This may be subject to change to singularly send a soon-to-be-created Packet interface.
     */
    public void sendTCP(Object object) {
        client.sendTCP(object);
    }
}

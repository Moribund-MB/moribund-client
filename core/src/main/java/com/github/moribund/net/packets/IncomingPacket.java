package com.github.moribund.net.packets;

/**
 * An {@code IncomingPacket} is a packet that is received by the server. This allows the client to follow the
 * Single-Responsibility Principle as now each packet is responsible for handling itself rather than a
 * {@link com.esotericsoftware.kryonet.Listener} being omnipotent and handling everything.
 */
public interface IncomingPacket {
    /**
     * Processes what to do when the packet is received.
     */
    void process();
}

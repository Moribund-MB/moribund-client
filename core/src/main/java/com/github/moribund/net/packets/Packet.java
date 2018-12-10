package com.github.moribund.net.packets;

/**
 * The {@code Packet} interface is here to enforce that
 * whatever we are sending through the TCP connection in
 * {@link com.github.moribund.net.PacketDispatcher} is only
 * a {@code Packet} and not random data bits. This is enforced
 * through the {@link com.github.moribund.net.PacketDispatcher#sendUDP(Packet)}
 * method parameter.
 */
public interface Packet {
}

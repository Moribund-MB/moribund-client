package com.github.moribund.net.packets;

/**
 * An {@code OutgoingPacket} is a packet that is sent by the client to the server. This allows for even
 * more restrained access to packet sending, as if it wasn't restrained enough, as a packet is now only
 * allowed to be sent to the server if it is of this type, enforced by the
 * {@link com.github.moribund.net.PacketDispatcher#sendUDP(OutgoingPacket)} method.
 */
public interface OutgoingPacket {
}

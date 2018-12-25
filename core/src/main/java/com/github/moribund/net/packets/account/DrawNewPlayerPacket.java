package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.Packet;
import lombok.Getter;

/**
 * An instruction by the server to the client to draw a new
 * {@link com.github.moribund.entity.Player} onto the screen.
 */
public class DrawNewPlayerPacket implements Packet {
    /**
     * The {@link com.github.moribund.entity.Player}'s unique ID.
     */
    @Getter
    private int playerId;
    @Getter
    private float x;
    @Getter
    private float y;
    @Getter
    private float rotation;
    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private DrawNewPlayerPacket() { }
}

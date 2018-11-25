package com.github.moribund.net.packets;

import com.github.moribund.entity.Tile;
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
    /**
     * The {@link Tile} the {@link com.github.moribund.entity.Player} resides on
     * when this instruction is given.
     */
    @Getter
    private Tile tile;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private DrawNewPlayerPacket() { }
}

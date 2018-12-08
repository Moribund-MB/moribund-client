package com.github.moribund.net.packets;

import lombok.Getter;

/**
 * The {@code TilePacket} sends the location of a given player to update the server.
 * This is an easy-to-manipulate packet should the client be decompiled
 * and abused, however.
 */
public class LocationPacket implements Packet {
    /**
     * The player ID of the player that is at the given tile.
     */
    @Getter
    private final int playerId;
    @Getter
    private final float x;
    @Getter
    private final float y;

    /**
     * The constructor to pass the player at the given tile.
     * @param playerId The player at the given tile.
     */
    public LocationPacket(int playerId, float x, float y) {
        this.playerId = playerId;
        this.x = x;
        this.y = y;
    }
}
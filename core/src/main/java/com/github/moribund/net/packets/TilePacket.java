package com.github.moribund.net.packets;

import com.github.moribund.entity.Tile;
import lombok.Getter;

/**
 * The {@code TilePacket} sends the {@link Tile} of a given player to update the server.
 * This is an easy-to-manipulate packet should the client be decompiled
 * and abused, however.
 */
public class TilePacket implements Packet {
    /**
     * The player ID of the player that is at the given tile.
     */
    @Getter
    private int playerId;
    /**
     * The location of the player.
     */
    @Getter
    private Tile tile;

    /**
     * The constructor to pass the player at the given tile.
     * @param playerId The player at the given tile.
     * @param tile The given tile that player is at.
     */
    public TilePacket(int playerId, Tile tile) {
        this.playerId = playerId;
        this.tile = tile;
    }
}
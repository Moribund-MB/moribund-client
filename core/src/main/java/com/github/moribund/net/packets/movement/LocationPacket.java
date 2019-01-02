package com.github.moribund.net.packets.movement;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.OutgoingPacket;
import lombok.val;

/**
 * The {@code TilePacket} sends the location of a given player to update the server.
 * This is an easy-to-manipulate packet should the client be decompiled
 * and abused, however.
 */
public final class LocationPacket implements IncomingPacket, OutgoingPacket {
    /**
     * The player ID of the player that is at the given tile.
     */
    private final int playerId;
    private final float x;
    private final float y;

    public LocationPacket(int playerId, float x, float y) {
        this.playerId = playerId;
        this.x = x;
        this.y = y;
    }

    LocationPacket() {
        playerId = -1;
        x = 0;
        y = 0;
    }

    @Override
    public void process() {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.setX(x);
        player.setY(y);
    }
}
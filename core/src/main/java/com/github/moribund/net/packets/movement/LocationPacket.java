package com.github.moribund.net.packets.movement;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Getter;
import lombok.val;

/**
 * The {@code TilePacket} sends the location of a given player to update the server.
 * This is an easy-to-manipulate packet should the client be decompiled
 * and abused, however.
 */
public class LocationPacket implements IncomingPacket, OutgoingPacket {
    /**
     * The player ID of the player that is at the given tile.
     */
    @Getter
    private int playerId;
    @Getter
    private float x;
    @Getter
    private float y;

    /**
     * The constructor to pass the player at the given tile.
     * @param playerId The player at the given tile.
     */
    public LocationPacket(int playerId, float x, float y) {
        this.playerId = playerId;
        this.x = x;
        this.y = y;
    }

    public LocationPacket() { }

    @Override
    public void process() {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.setX(x);
        player.setY(y);
    }
}
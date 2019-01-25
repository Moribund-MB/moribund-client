package com.github.moribund.net.packets.graphics;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import lombok.val;

/**
 * The packet sent by the server to tell the client to update the appearance of a certain character.
 */
public final class UpdateAppearancePacket implements IncomingPacket {

    /**
     * The player ID of the player to update.
     */
    private int playerId;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private UpdateAppearancePacket() { }

    @Override
    public void process() {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.updateAppearance();
    }
}

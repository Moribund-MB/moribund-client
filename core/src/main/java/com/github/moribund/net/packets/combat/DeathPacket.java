package com.github.moribund.net.packets.combat;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.utils.PlayerUtils;

/**
 * A packet by the server to signify the death of a player.
 */
public final class DeathPacket implements IncomingPacket {
    /**
     * The player ID of the player that died.
     */
    private int playerId;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private DeathPacket() { }

    @Override
    public void process() {
        PlayerUtils.deletePlayer(playerId);

        if (playerId == MoribundClient.getInstance().getPlayer().getPlayerId()) {
            PlayerUtils.switchToNewTitleScreen();
        }
    }
}

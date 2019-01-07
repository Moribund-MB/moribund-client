package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.utils.PlayerUtils;

/**
 * A packet that indicates a player has disconnected. This allows for the server and client to enact the appropriate
 * clearing methods to remove the Player from their data.
 */
public final class LogoutPacket implements IncomingPacket {
    private int gameId;
    /**
     * The player ID of the player that disconnected.
     */
    private int playerId;

    @Override
    public void process() {
        PlayerUtils.deletePlayer(playerId);
    }
}

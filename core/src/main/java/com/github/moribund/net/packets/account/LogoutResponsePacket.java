package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.utils.PlayerUtils;

public final class LogoutResponsePacket implements IncomingPacket {
    /**
     * The player ID of the player that disconnected.
     */
    private int playerId;

    private LogoutResponsePacket() { }

    @Override
    public void process() {
        PlayerUtils.deletePlayer(playerId);
    }
}
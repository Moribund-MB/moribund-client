package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.utils.PlayerUtils;

public final class LogoutPacket implements IncomingPacket {
    private int playerId;

    @Override
    public void process() {
        PlayerUtils.deletePlayer(playerId);
    }
}

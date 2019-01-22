package com.github.moribund.net.packets.account;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import lombok.val;

public class UpdateAppearancePacket implements IncomingPacket {
    private int playerId;

    private UpdateAppearancePacket() { }

    @Override
    public void process() {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.updateAppearance();
    }
}

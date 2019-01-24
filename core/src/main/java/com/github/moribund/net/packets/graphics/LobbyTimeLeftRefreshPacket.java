package com.github.moribund.net.packets.graphics;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;

public class LobbyTimeLeftRefreshPacket implements IncomingPacket {
    private String display;

    @Override
    public void process() {
        MoribundClient.getInstance().getPlayer().getLobbyTimer().setDisplayText(display);
    }
}

package com.github.moribund.net.packets.graphics;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;

public class TimeLeftRefreshPacket implements IncomingPacket {
    private String displayText;

    @Override
    public void process() {
        if (displayText != null) {
            MoribundClient.getInstance().getPlayer().getTimer().setDisplayText(displayText);
        }
    }
}

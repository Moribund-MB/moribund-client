package com.github.moribund.net.packets.graphics;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;

/**
 * The packet used to send text to the {@link com.github.moribund.objects.playable.players.ui.DeathTimer#displayText}.
 */
public class TimeLeftRefreshPacket implements IncomingPacket {

    /**
     * The display text to display for the lobby timer.
     */
    private String displayText;

    @Override
    public void process() {
        if (displayText != null) {
            MoribundClient.getInstance().getPlayer().getDeathTimer().setDisplayText(displayText);
        }
    }
}

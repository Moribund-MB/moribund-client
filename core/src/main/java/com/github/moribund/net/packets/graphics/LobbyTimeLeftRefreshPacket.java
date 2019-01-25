package com.github.moribund.net.packets.graphics;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;

/**
 * The packet used to send text to the {@link com.github.moribund.objects.playable.players.ui.LobbyTimer#displayText}.
 */
public class LobbyTimeLeftRefreshPacket implements IncomingPacket {

    /**
     * The display text to display for the lobby timer.
     */
    private String display;

    @Override
    public void process() {
        MoribundClient.getInstance().getPlayer().getLobbyTimer().setDisplayText(display);
    }
}

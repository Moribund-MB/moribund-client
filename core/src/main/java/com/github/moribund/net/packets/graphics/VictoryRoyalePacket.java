package com.github.moribund.net.packets.graphics;

import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.fonts.FontFile;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.objects.playable.players.ui.VictoryRoyaleText;
import lombok.val;

/**
 * A {@code VictoryRoyalePacket} is named based on <a href="http://fortnite.com">Fortnite</a>'s winning screen
 * which says "Victory Royale!" Essentially, this packet is an interface packet sent to the client to indicate
 * to display the victory interface.
 */
public final class VictoryRoyalePacket implements IncomingPacket {
    /**
     * The ID of the player that won.
     */
    private int playerId;

    private VictoryRoyalePacket() { }

    @Override
    public void process() {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        if (player == null || player.getUsername() == null) {
            return;
        }
        MoribundClient.getInstance().getDrawableUIAssets().add(new VictoryRoyaleText(player.getUsername(), FontFile.CODE_LIGHT_2));
    }
}

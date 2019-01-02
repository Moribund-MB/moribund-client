package com.github.moribund.net.packets.movement;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.OutgoingPacket;
import lombok.val;

public final class RotationPacket implements IncomingPacket, OutgoingPacket {
    /**
     * The player ID of the player that is finished rotating.
     */
    private final int playerId;
    private final float angle;

    public RotationPacket(int playerId, float angle) {
        this.playerId = playerId;
        this.angle = angle;
    }

    RotationPacket() {
        playerId = -1;
        angle = 0;
    }

    @Override
    public void process() {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.setRotation(angle);
    }
}

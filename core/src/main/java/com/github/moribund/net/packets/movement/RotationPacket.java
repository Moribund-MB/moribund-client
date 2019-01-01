package com.github.moribund.net.packets.movement;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncommingPacket;
import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Getter;
import lombok.val;

public class RotationPacket implements IncommingPacket, OutgoingPacket {
    /**
     * The player ID of the player that is finished rotating.
     */
    @Getter
    private int playerId;
    @Getter
    private float angle;

    public RotationPacket(int playerId, float angle) {
        this.playerId = playerId;
        this.angle = angle;
    }

    public RotationPacket() { }

    @Override
    public void process() {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.setRotation(angle);
    }
}

package com.github.moribund.net.packets.movement;

import com.github.moribund.net.packets.Packet;
import lombok.Getter;

public class RotationPacket implements Packet {
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
}

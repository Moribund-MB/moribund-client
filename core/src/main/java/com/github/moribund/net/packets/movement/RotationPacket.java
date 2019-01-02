package com.github.moribund.net.packets.movement;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.OutgoingPacket;
import lombok.val;

/**
 * The {@code RotationPacket} sends the angle of a given player to update the server.
 * This packet is sent every LibGDX game cycle ({@link com.badlogic.gdx.Screen#render(float)})
 * and is constantly supplying the server where the player currently is for as long as a
 * rotation {@link com.github.moribund.objects.flags.Flag} is active. This is an
 * easy-to-manipulate packet should the client be decompiled and abused, however.
 */
public final class RotationPacket implements IncomingPacket, OutgoingPacket {
    /**
     * The player ID of the player that is finished rotating.
     */
    private final int playerId;
    /**
     * The angle at which the player is now.
     */
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

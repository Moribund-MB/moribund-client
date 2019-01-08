package com.github.moribund.objects.flags.rotating;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.movement.RotationPacket;
import com.github.moribund.objects.flags.Flag;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import lombok.val;

/**
 * A {@link RotateFlag} is a flag that signifies a {@link com.github.moribund.objects.attributes.Movable} is rotating.
 */
abstract class RotateFlag implements Flag {
    /**
     * Sends the rotation packet to the server should this be a {@link PlayableCharacter}.
     * @param playableCharacter The {@link PlayableCharacter} that just rotated.
     */
    void sendRotationPacket(PlayableCharacter playableCharacter) {
        val packetDispatcher = MoribundClient.getInstance().getPacketDispatcher();
        val rotationPacket = new RotationPacket(playableCharacter.getGameId(), playableCharacter.getPlayerId(), playableCharacter.getRotation());
        packetDispatcher.sendUDP(rotationPacket);
    }
}

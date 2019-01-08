package com.github.moribund.objects.flags.movement;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.movement.LocationPacket;
import com.github.moribund.objects.flags.Flag;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import lombok.val;

/**
 * An {@link MovementFlag} is a flag that signifies a {@link com.github.moribund.objects.attributes.Movable} is moving.
 */
abstract class MovementFlag implements Flag {
    /**
     * Sends the location packet to the server should this be a {@link PlayableCharacter}.
     * @param playableCharacter The {@link PlayableCharacter} that just moved.
     */
    void sendLocationPacket(PlayableCharacter playableCharacter) {
        val packetDispatcher = MoribundClient.getInstance().getPacketDispatcher();
        val tilePacket = new LocationPacket(playableCharacter.getGameId(), playableCharacter.getPlayerId(), playableCharacter.getX(), playableCharacter.getY());
        packetDispatcher.sendUDP(tilePacket);
    }
}

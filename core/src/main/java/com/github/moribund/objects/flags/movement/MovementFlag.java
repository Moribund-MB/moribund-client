package com.github.moribund.objects.flags.movement;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.movement.LocationPacket;
import com.github.moribund.objects.flags.Flag;
import com.github.moribund.objects.playable.PlayableCharacter;
import lombok.val;

abstract class MovementFlag implements Flag {
    void sendLocationPacket(PlayableCharacter playableCharacter) {
        val packetDispatcher = MoribundClient.getInstance().getPacketDispatcher();
        val tilePacket = new LocationPacket(playableCharacter.getPlayerId(), playableCharacter.getX(), playableCharacter.getY());
        packetDispatcher.sendUDP(tilePacket);
    }
}

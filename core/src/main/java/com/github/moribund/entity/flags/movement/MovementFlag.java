package com.github.moribund.entity.flags.movement;

import com.github.moribund.MoribundClient;
import com.github.moribund.entity.PlayableCharacter;
import com.github.moribund.entity.flags.Flag;
import com.github.moribund.net.packets.movement.LocationPacket;
import lombok.val;

abstract class MovementFlag implements Flag {
    void sendLocationPacket(PlayableCharacter playableCharacter) {
        val packetDispatcher = MoribundClient.getInstance().getPacketDispatcher();
        val tilePacket = new LocationPacket(playableCharacter.getPlayerId(), playableCharacter.getX(), playableCharacter.getY());
        packetDispatcher.sendUDP(tilePacket);
    }
}

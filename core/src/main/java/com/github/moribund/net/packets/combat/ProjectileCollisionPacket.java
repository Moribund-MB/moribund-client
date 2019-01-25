package com.github.moribund.net.packets.combat;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

@Value
public class ProjectileCollisionPacket implements OutgoingPacket {
    private int gameId;
    private int playerId;
    private int sourcePlayerId;
    private int projectileId;
}

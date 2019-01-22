package com.github.moribund.net.packets.items;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

@Value
public class ItemOnItemPacket implements OutgoingPacket {
    private int gameId;
    private int playerId;
    private int slotSelected1;
    private int slotSelected2;
}

package com.github.moribund.net.packets.items;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

@Value
public class UnequipItemPacket implements OutgoingPacket {
    private int gameId;
    private int playerId;
    private int equipmentSlot;
}

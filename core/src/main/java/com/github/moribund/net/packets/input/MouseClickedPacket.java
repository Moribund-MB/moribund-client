package com.github.moribund.net.packets.input;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

@Value
public class MouseClickedPacket implements OutgoingPacket {
    private int gameId;
    private int playerId;
}

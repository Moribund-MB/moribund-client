package com.github.moribund.net.packets;

import lombok.Getter;

public class MovingFlagPacket {
    @Getter
    private int direction;
    @Getter
    private int playerId;

    private MovingFlagPacket() { }
}

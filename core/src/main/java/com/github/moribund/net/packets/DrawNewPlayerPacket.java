package com.github.moribund.net.packets;

import lombok.Getter;

public class DrawNewPlayerPacket {
    @Getter
    private int playerId;
    @Getter
    private int x;
    @Getter
    private int y;

    private DrawNewPlayerPacket() { }
}

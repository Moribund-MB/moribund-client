package com.github.moribund.net.packets;

import com.github.moribund.entity.Tile;
import lombok.Getter;

public class DrawNewPlayerPacket {
    @Getter
    private int playerId;
    @Getter
    private Tile tile;

    private DrawNewPlayerPacket() { }
}

package com.github.moribund.net.packets;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.moribund.entity.Tile;
import lombok.Getter;

// not really concerned about cheating, not sure if I should be?
public class TilePacket {
    @Getter
    private int playerId;
    @Getter
    private Tile tile;

    public TilePacket(int playerId, Tile tile) {
        this.playerId = playerId;
        this.tile = tile;
    }
}
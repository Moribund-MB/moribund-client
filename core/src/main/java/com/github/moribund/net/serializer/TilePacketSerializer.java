package com.github.moribund.net.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.moribund.entity.Tile;
import com.github.moribund.net.packets.TilePacket;
import lombok.val;

public class TilePacketSerializer extends Serializer<TilePacket> {
    @Override
    public void write(Kryo kryo, Output output, TilePacket object) {
        output.writeInt(object.getPlayerId());
        kryo.writeObject(output, object.getTile());
        output.close();
    }

    @Override
    public TilePacket read(Kryo kryo, Input input, Class<TilePacket> type) {
        val playerId = input.readInt();
        val tile = kryo.readObject(input, Tile.class);
        input.close();
        return new TilePacket(playerId, tile);
    }
}

package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.net.packets.IncommingPacket;
import lombok.val;

public class PacketListener extends Listener {
    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof IncommingPacket) {
            val incommingPacket = (IncommingPacket) object;
            incommingPacket.process();
        }
    }
}

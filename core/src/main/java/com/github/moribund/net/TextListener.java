package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.net.packets.MessagePacket;

public class TextListener extends Listener {
    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof MessagePacket) {
            MessagePacket messagePacket = (MessagePacket) object;
            System.out.println("[" + messagePacket.getName() + "] " + messagePacket.getMessage());
        }
    }
}

package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.net.packets.MovingFlagPacket;
import lombok.val;

public class MovementListener extends Listener {
    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof MovingFlagPacket) {
            val movingFlagPacket = (MovingFlagPacket) object;

        }
    }
}

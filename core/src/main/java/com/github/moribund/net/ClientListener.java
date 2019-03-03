package com.github.moribund.net;

import com.badlogic.gdx.Gdx;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.net.packets.IncomingPacket;
import lombok.val;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The overall packet listener. All this listener does is see if an object is an {@link IncomingPacket} and
 * call {@link IncomingPacket#process()}. This allows for a lot of safety of info as the client now has
 * distinguishment of what packet is of what classification. Refer to {@link IncomingPacket}'s documentation
 * for more info.
 */
class ClientListener extends Listener {
    @Override
    public void disconnected(Connection connection) {
        Gdx.app.exit();

        try {
            val writer = new FileWriter("application_error.txt");
            writer.write("The server has been disconnected from the client! Perhaps the server has crashed?");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof IncomingPacket) {
            val incomingPacket = (IncomingPacket) object;
            incomingPacket.process();
        }
    }
}

package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.account.LogoutPacket;
import lombok.val;

/**
 * The overall packet listener. All this listener does is see if an object is an {@link IncomingPacket} and
 * call {@link IncomingPacket#process()}. This allows for a lot of safety of info as the client now has
 * distinguishment of what packet is of what classification. Refer to {@link IncomingPacket}'s documentation
 * for more info. This listener also checks to see if a {@link com.github.moribund.objects.playable.Player} has disconnected
 * and sends a {@link com.github.moribund.net.packets.account.LogoutPacket} accordingly.
 */
public class ClientListener extends Listener {
    @Override
    public void disconnected(Connection connection) {
        val player = MoribundClient.getInstance().getPlayer();
        connection.sendTCP(new LogoutPacket(player.getGameId(), player.getPlayerId()));
    }

    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof IncomingPacket) {
            val incomingPacket = (IncomingPacket) object;
            incomingPacket.process();
        }
    }
}

package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.LocationPacket;
import lombok.val;

/**
 * The {@code MovementListener} listens to all packets relating
 * to the positions of {@link com.github.moribund.entity.PlayableCharacter}s
 * due to movement.
 */
public class MovementListener extends Listener {
    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof LocationPacket) {
            val tilePacket = (LocationPacket) object;
            val playerId = tilePacket.getPlayerId();
            val x = tilePacket.getX();
            val y = tilePacket.getY();
            setLocationForPlayer(x, y, playerId);
        }
    }

    private void setLocationForPlayer(float x, float y, int playerId) {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.setX(x);
        player.setY(y);
    }
}

package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.LocationPacket;
import com.github.moribund.net.packets.RotationPacket;
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
            val locationPacket = (LocationPacket) object;
            val playerId = locationPacket.getPlayerId();
            val x = locationPacket.getX();
            val y = locationPacket.getY();

            setLocationForPlayer(x, y, playerId);
            // todo perhaps the 100 ms check for locations
        } else if (object instanceof RotationPacket) {
            val rotationPacket = (RotationPacket) object;
            val playerId = rotationPacket.getPlayerId();
            val angle = rotationPacket.getAngle();

            setRotationForPlayer(angle, playerId);
        }
    }

    private void setRotationForPlayer(float angle, int playerId) {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.setRotation(angle);
    }

    private void setLocationForPlayer(float x, float y, int playerId) {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.setX(x);
        player.setY(y);
    }
}

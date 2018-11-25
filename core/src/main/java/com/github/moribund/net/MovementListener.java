package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.MoribundClient;
import com.github.moribund.entity.Tile;
import com.github.moribund.net.packets.TilePacket;
import lombok.val;

/**
 * The {@code MovementListener} listens to all packets relating
 * to the positions of {@link com.github.moribund.entity.PlayableCharacter}s
 * due to movement.
 */
public class MovementListener extends Listener {
    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof TilePacket) {
            val tilePacket = (TilePacket) object;
            val playerId = tilePacket.getPlayerId();
            val tile = tilePacket.getTile();
            setTileForPlayer(tile, playerId);
        }
    }

    private void setTileForPlayer(Tile tile, int playerId) {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.setTile(tile);
    }
}

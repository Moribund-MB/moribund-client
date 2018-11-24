package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.MoribundClient;
import com.github.moribund.entity.Tile;
import com.github.moribund.entity.Player;
import com.github.moribund.net.packets.DrawNewPlayerPacket;
import com.github.moribund.net.packets.LoginPacket;
import lombok.val;

/**
 * The {@code AccountListener} listens to all packets relating
 * to accounts (account creation, etc).
 */
public class AccountListener extends Listener {
    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof DrawNewPlayerPacket) {
            val drawNewPlayerPacket = (DrawNewPlayerPacket) object;
            makePlayer(drawNewPlayerPacket.getPlayerId(), drawNewPlayerPacket.getTile());
        } else if (object instanceof LoginPacket) {
            val loginPacket = (LoginPacket) object;
            loginPacket.getPlayerLocations().forEach(pair -> {
                val playerId = pair.getKey();
                val tile = pair.getValue();
                makePlayer(playerId, tile);
            });
        }
    }

    /**
     * Makes a new player and sets their coordinates for rendering them.
     * @param playerId The unique player ID of the character made.
     * @param tile The tile the player stands on when made.
     */
    private void makePlayer(int playerId, Tile tile) {
        val player = new Player(playerId);
        val playersMap = MoribundClient.getInstance().getPlayers();

        playersMap.put(playerId, player);
        player.setTile(tile);
    }
}
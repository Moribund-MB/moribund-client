package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.MoribundClient;
import com.github.moribund.entity.Tile;
import com.github.moribund.entity.Player;
import com.github.moribund.net.packets.DrawNewPlayerPacket;
import com.github.moribund.net.packets.LoginPacket;
import lombok.val;

public class AccountListener extends Listener {
    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof DrawNewPlayerPacket) {
            val drawNewPlayerPacket = (DrawNewPlayerPacket) object;
            makePlayer(drawNewPlayerPacket.getPlayerId(), new Tile(drawNewPlayerPacket.getX(),
                    drawNewPlayerPacket.getY()));
        } else if (object instanceof LoginPacket) {
            val loginPacket = (LoginPacket) object;
            loginPacket.getPlayerIds().forEach(pair -> {
                val playerId = pair.getKey();
                val coordinatePair = pair.getValue();
                makePlayer(playerId, Tile.pairToCoordinate(coordinatePair));
            });
        }
    }

    private void makePlayer(int playerId, Tile tile) {
        val player = new Player(playerId);
        MoribundClient.getInstance().getPlayers().put(playerId, player);
        player.setTile(tile);
    }
}
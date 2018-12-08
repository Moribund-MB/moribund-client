package com.github.moribund.net;

import com.badlogic.gdx.Gdx;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.MoribundClient;
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
            makePlayer(drawNewPlayerPacket.getPlayerId(), drawNewPlayerPacket.getX(), drawNewPlayerPacket.getY());
            rotatePlayer(drawNewPlayerPacket.getPlayerId(), drawNewPlayerPacket.getRotation());
        } else if (object instanceof LoginPacket) {
            val loginPacket = (LoginPacket) object;
            loginPacket.getPlayerLocations().forEach(pair -> {
                val playerId = pair.getKey();
                val location = pair.getValue();
                val x = location.getKey();
                val y = location.getValue();
                makePlayer(playerId, x, y);
            });
            loginPacket.getPlayerRotations().forEach(pair -> {
                val playerId = pair.getKey();
                val rotation = pair.getValue();
                rotatePlayer(playerId, rotation);
            });
            setClientPlayer(loginPacket.getPlayerId());
        }
    }

    private void rotatePlayer(int playerId, float rotation) {
        val playersMap = MoribundClient.getInstance().getPlayers();
        playersMap.get(playerId).setRotation(rotation);
    }

    private void setClientPlayer(int playerId) {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        MoribundClient.getInstance().setPlayer(player);
        if (player instanceof Player) {
            val actualPlayer = (Player) player;
            Gdx.input.setInputProcessor(actualPlayer);
        }
    }

    /**
     * Makes a new player and sets their coordinates for rendering them.
     * @param playerId The unique player ID of the character made.
     */
    private void makePlayer(int playerId, float x, float y) {
        val player = new Player(playerId);
        val playersMap = MoribundClient.getInstance().getPlayers();

        playersMap.put(playerId, player);
        player.setX(x);
        player.setY(y);
    }
}
package com.github.moribund.utils;

import com.badlogic.gdx.Gdx;
import com.github.moribund.MoribundClient;
import com.github.moribund.objects.Player;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class PlayerUtils {
    public void rotatePlayer(int playerId, float rotation) {
        val playersMap = MoribundClient.getInstance().getPlayers();
        playersMap.get(playerId).setRotation(rotation);
    }

    public void setClientPlayer(int playerId) {
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
    public void makePlayer(int playerId, float x, float y) {
        val player = new Player(playerId);
        val client = MoribundClient.getInstance();

        client.getPlayers().put(playerId, player);
        client.getDrawables().add(player);
        client.getFlaggables().add(player);

        player.setX(x);
        player.setY(y);
    }

    public void deletePlayer(int playerId) {
        val client = MoribundClient.getInstance();
        val player = client.getPlayers().get(playerId);

        client.getDrawables().remove(player);
        client.getFlaggables().remove(player);
        client.getPlayers().remove(playerId);
    }
}

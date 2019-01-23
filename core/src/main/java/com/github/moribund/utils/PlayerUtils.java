package com.github.moribund.utils;

import com.badlogic.gdx.Gdx;
import com.github.moribund.MoribundClient;
import com.github.moribund.objects.playable.players.Player;
import lombok.experimental.UtilityClass;
import lombok.val;

/**
 * The utility methods that aid in the handling of players.
 */
@UtilityClass
public class PlayerUtils {
    /**
     * Rotates a player.
     * @param playerId The player ID of the rotating player.
     * @param rotation The angle to rotate about its current angle.
     */
    public void rotatePlayer(int playerId, float rotation) {
        val playersMap = MoribundClient.getInstance().getPlayers();
        playersMap.get(playerId).setRotation(rotation);
    }

    /**
     * Sets the {@link MoribundClient#player} to a given player ID.
     * @param playerId The ID of the {@link MoribundClient#player} controlling this {@link MoribundClient}.
     */
    public void setClientPlayer(int playerId) {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        MoribundClient.getInstance().setPlayer(player);
        Gdx.input.setInputProcessor(player);
        if (player instanceof Player) {
            val actualPlayer = (Player) player;
            actualPlayer.addUIAssets();
        }
    }

    /**
     * Makes a new player and sets their coordinates for rendering them.
     * @param playerId The unique player ID of the character made.
     */
    public void makePlayer(int gameId, int playerId, String username, float x, float y, int hitpoints) {
        val player = new Player(gameId, playerId, username, hitpoints);
        val client = MoribundClient.getInstance();

        client.getPlayers().put(playerId, player);
        client.getDrawableGameAssets().add(player);
        client.getFlaggables().add(player);

        player.setX(x);
        player.setY(y);
    }

    /**
     * Deletes a player from the {@link MoribundClient#players} map.
     * @param playerId The player ID (or key) of the player to delete.
     */
    public void deletePlayer(int playerId) {
        val client = MoribundClient.getInstance();
        val player = client.getPlayers().get(playerId);

        client.getDrawableGameAssets().remove(player);
        client.getFlaggables().remove(player);
        client.getPlayers().remove(playerId);
    }
}

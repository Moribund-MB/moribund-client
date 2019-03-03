package com.github.moribund.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.MoribundClient;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.objects.playable.players.Player;
import com.github.moribund.screens.title.TitleScreen;
import com.github.moribund.screens.title.TitleScreenFactory;
import lombok.experimental.UtilityClass;
import lombok.val;

/**
 * The utility methods that aid in the handling of players.
 */
@UtilityClass
public class PlayerUtils {

    /**
     * Sets the {@link MoribundClient#player} to a given player ID.
     *
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

    public void switchToNewTitleScreen() {
        Gdx.app.postRunnable(() -> {
            val titleScreenFactory = new TitleScreenFactory();
            MoribundClient.getInstance().switchToScreen(titleScreenFactory.createScreen(), true);
        });
    }

    public void switchToTitleScreen(MusicPlayer musicPlayer, Batch batch, Sprite background, Camera camera) {
        val titleScreen = new TitleScreen(musicPlayer, batch, background, camera);
        MoribundClient.getInstance().switchToScreen(titleScreen, false);
    }

    /**
     * Makes a new player and sets their coordinates for rendering them. This method adds the player to the
     * maps and sets for rendering.
     *
     * @param playerId The unique player ID of the character made.
     * @return The newly made player that has been added to the player map.
     */
    public Player makePlayer(int gameId, int playerId, String username, float x, float y, float rotation, int hitpoints) {
        val player = new Player(gameId, playerId, username, hitpoints);
        val client = MoribundClient.getInstance();

        client.getPlayers().put(playerId, player);
        client.getDrawableGameAssets().add(player);
        client.getFlaggables().add(player);

        player.setX(x);
        player.setY(y);
        player.setRotation(rotation);
        return player;
    }

    /**
     * Deletes a player from the {@link MoribundClient#players} map.
     *
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

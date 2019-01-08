package com.github.moribund.net.packets.game;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import com.github.moribund.objects.playable.players.Player;
import it.unimi.dsi.fastutil.objects.ObjectList;
import javafx.util.Pair;
import lombok.val;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * The game state packet. This packet is here to ensure the server and client
 * are always in sync. This packet is sent by the server every 100 MS and provides
 * all the locations and rotational axis the server thinks the players are. Moribund
 * operates with a priority to the server, so all existing configurations of players
 * locations and rotations will be overridden with these configurations sent by
 * the server.
 */
public final class GameStatePacket implements IncomingPacket {

    /**
     * The locations of all {@link Player}s in the game at the moment.
     */
    private ObjectList<Pair<Integer, Pair<Float, Float>>> playerLocations;
    /**
     * The rotation angle of all {@link Player}s in the game at the moment.
     */
    private ObjectList<Pair<Integer, Float>> playerRotations;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private GameStatePacket() { }

    @Override
    public void process() {
        forEachPlayer(playerLocations, (player, data) -> {
            val x = data.getKey();
            val y = data.getValue();

            player.setX(x);
            player.setY(y);
        });
        forEachPlayer(playerRotations, PlayableCharacter::setRotation);
    }

    /**
     * A handy generic-utilizing method that allows for something to be done to each player in a
     * List<Pair<Integer, V>>, with the Integer representing the player's ID and V representing the data.
     * @param players The list of configurations.
     * @param consumer The consumer of what to do with each player after they have been fetched from their player ID.
     * @param <V> The type of the respective data.
     */
    private <V> void forEachPlayer(List<Pair<Integer, V>> players, BiConsumer<PlayableCharacter, V> consumer) {
        players.forEach(playerInList -> {
            int playerId = playerInList.getKey();

            val player = MoribundClient.getInstance().getPlayers().get(playerId);
            consumer.accept(player, playerInList.getValue());
        });
    }
}

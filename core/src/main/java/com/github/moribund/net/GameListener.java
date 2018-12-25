package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.github.moribund.MoribundClient;
import com.github.moribund.entity.PlayableCharacter;
import com.github.moribund.net.packets.game.GameStatePacket;
import javafx.util.Pair;
import lombok.val;

import java.util.List;
import java.util.function.BiConsumer;

public class GameListener extends Listener {

    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof GameStatePacket) {
            val gameStatePacket = (GameStatePacket) object;
            val playerLocations = gameStatePacket.getPlayerLocations();
            val playerRotations = gameStatePacket.getPlayerRotations();

            forEachPlayer(playerLocations, (player, data) -> {
                val x = data.getKey();
                val y = data.getValue();

                player.setX(x);
                player.setY(y);
            });
            forEachPlayer(playerRotations, PlayableCharacter::setRotation);
        }
    }

    private <V> void forEachPlayer(List<Pair<Integer, V>> players, BiConsumer<PlayableCharacter, V> consumer) {
        players.forEach(playerInList -> {
            int playerId = playerInList.getKey();

            val player = MoribundClient.getInstance().getPlayers().get(playerId);
            consumer.accept(player, playerInList.getValue());
        });
    }
}

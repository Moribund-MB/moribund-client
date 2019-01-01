package com.github.moribund.net.packets.game;

import com.github.moribund.MoribundClient;
import com.github.moribund.entity.PlayableCharacter;
import com.github.moribund.net.packets.IncomingPacket;
import javafx.util.Pair;
import lombok.Getter;
import lombok.val;

import java.util.List;
import java.util.function.BiConsumer;

public class GameStatePacket implements IncomingPacket {
    @Getter
    private List<Pair<Integer, Pair<Float, Float>>> playerLocations;
    @Getter
    private List<Pair<Integer, Float>> playerRotations;

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

    private <V> void forEachPlayer(List<Pair<Integer, V>> players, BiConsumer<PlayableCharacter, V> consumer) {
        players.forEach(playerInList -> {
            int playerId = playerInList.getKey();

            val player = MoribundClient.getInstance().getPlayers().get(playerId);
            consumer.accept(player, playerInList.getValue());
        });
    }
}

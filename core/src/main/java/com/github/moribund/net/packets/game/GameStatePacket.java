package com.github.moribund.net.packets.game;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.data.PlayerData;
import com.github.moribund.objects.playable.players.Player;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.val;

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
    private ObjectList<PlayerData> playerData;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private GameStatePacket() { }

    @Override
    public void process() {
        playerData.forEach(data -> {
            val player = MoribundClient.getInstance().getPlayers().get(data.getPlayerId());
            if (player != null) {
                player.setX(data.getX());
                player.setY(data.getY());
                player.setRotation(data.getRotation());
                player.setHitpoints(data.getHitpoints());
                player.getInventory().setItemIds(data.getInventoryItems());
                player.getEquipment().setItemIds(data.getEquipmentItems());
            }
        });

    }
}

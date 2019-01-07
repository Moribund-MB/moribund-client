package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.objects.nonplayable.items.GroundItem;
import com.github.moribund.objects.nonplayable.items.GroundItemType;
import com.github.moribund.objects.playable.Player;
import com.github.moribund.utils.PlayerUtils;
import it.unimi.dsi.fastutil.objects.ObjectList;
import javafx.util.Pair;
import lombok.val;

/**
 * The response from the server that a {@link Player}
 * has logged in. This makes the client do instructions by this message's
 * arrival.
 */
public final class CreateNewPlayerPacket implements IncomingPacket {
    private int gameId;
    /**
     * The unique player ID of the one who just logged in.
     */
    private int playerId;
    /**
     * The locations of all the {@link Player}s in the
     * game currently so that they may be rendered to this player logging in.
     */
    private ObjectList<Pair<Integer, Pair<Float, Float>>> playerLocations;
    /**
     * The rotations of all the {@link Player}s in the
     * game currently so that they may be rendered to this player logging in.
     */
    private ObjectList<Pair<Integer, Float>> playerRotations;

    /**
     * TODO SERIOUSLY MAKE POJOS FOR ALL THESE CUZ THIS IS RIDICULOUS
     */
    private ObjectList<Pair<Integer, Pair<Float, Float>>> groundItems;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private CreateNewPlayerPacket() { }

    @Override
    public void process() {
        groundItems.forEach(pair -> {
            val type = GroundItemType.getGroundItemType(pair.getKey());
            val x = pair.getValue().getKey();
            val y = pair.getValue().getValue();
            val groundItem = new GroundItem(type, x, y);
            GroundItem.addGroundItem(groundItem);
        });
        playerLocations.forEach(pair -> {
            val playerId = pair.getKey();
            val location = pair.getValue();
            val x = location.getKey();
            val y = location.getValue();
            PlayerUtils.makePlayer(gameId, playerId, x, y);
        });
        playerRotations.forEach(pair -> {
            val playerId = pair.getKey();
            val rotation = pair.getValue();
            PlayerUtils.rotatePlayer(playerId, rotation);
        });
        PlayerUtils.setClientPlayer(playerId);
    }
}

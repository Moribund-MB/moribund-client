package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.utils.PlayerUtils;
import javafx.util.Pair;
import lombok.Getter;
import lombok.val;

import java.util.List;

/**
 * The response from the server that a {@link com.github.moribund.objects.Player}
 * has logged in. This makes the client do instructions by this message's
 * arrival.
 */
public class LoginPacket implements IncomingPacket {
    /**
     * The unique player ID of the one who just logged in.
     */
    @Getter
    private int playerId;
    /**
     * The locations of all the {@link com.github.moribund.objects.Player}s in the
     * game currently so that they may be rendered to this player logging in.
     */
    @Getter
    private List<Pair<Integer, Pair<Float, Float>>> playerLocations;
    @Getter
    private List<Pair<Integer, Float>> playerRotations;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private LoginPacket() { }

    @Override
    public void process() {
        playerLocations.forEach(pair -> {
            val playerId = pair.getKey();
            val location = pair.getValue();
            val x = location.getKey();
            val y = location.getValue();
            PlayerUtils.makePlayer(playerId, x, y);
        });
        playerRotations.forEach(pair -> {
            val playerId = pair.getKey();
            val rotation = pair.getValue();
            PlayerUtils.rotatePlayer(playerId, rotation);
        });
        PlayerUtils.setClientPlayer(playerId);
    }
}

package com.github.moribund.net.packets;

import com.github.moribund.entity.Tile;
import javafx.util.Pair;
import lombok.Getter;

import java.util.List;

/**
 * The response from the server that a {@link com.github.moribund.entity.Player}
 * has logged in. This makes the client do instructions by this message's
 * arrival.
 */
public class LoginPacket {
    /**
     * The unique player ID of the one who just logged in.
     */
    @Getter
    private int playerId;
    /**
     * The locations of all the {@link com.github.moribund.entity.Player}s in the
     * game currently so that they may be rendered to this player logging in.
     */
    @Getter
    private List<Pair<Integer, Tile>> playerLocations;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private LoginPacket() { }
}
package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.objects.playable.Player;
import com.github.moribund.utils.PlayerUtils;

/**
 * An instruction by the server to the client to draw a new
 * {@link Player} onto the screen.
 */
public final class DrawNewPlayerPacket implements IncomingPacket {
    /**
     * The {@link Player}'s unique ID.
     */
    private int playerId;
    private float x;
    private float y;
    private float rotation;
    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private DrawNewPlayerPacket() { }

    @Override
    public void process() {
        PlayerUtils.makePlayer(playerId, x, y);
        PlayerUtils.rotatePlayer(playerId, rotation);
    }
}

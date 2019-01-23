package com.github.moribund.net.packets.input;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

/**
 * Sends a packet to the server as soon as a key is released. Key sending is
 * synchronous, meaning that it is sent to the server as soon as it happens,
 * not in accordance to the 100 MS game state.
 */
@Value
public class KeyUnpressedPacket implements OutgoingPacket {
    private int gameId;
    /**
     * The unique player ID of the player that owns this client.
     */
    private int playerId;
    /**
     * The {@link com.badlogic.gdx.Input.Keys} value released.
     */
    private int keyUnpressed;
}

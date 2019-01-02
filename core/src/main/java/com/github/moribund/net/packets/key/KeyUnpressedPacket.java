package com.github.moribund.net.packets.key;

import com.github.moribund.net.packets.OutgoingPacket;
import com.github.moribund.objects.playable.Player;
import lombok.Value;

/**
 * Sends a packet to the server to allow for client-server latency of
 * the {@link com.badlogic.gdx.Input.Keys} value released by the
 * {@link Player} that owns this client.
 */
@Value
public class KeyUnpressedPacket implements OutgoingPacket {
    /**
     * The unique player ID of the player that owns this client.
     */
    private int playerId;
    /**
     * The {@link com.badlogic.gdx.Input.Keys} value released.
     */
    private int keyUnpressed;
}

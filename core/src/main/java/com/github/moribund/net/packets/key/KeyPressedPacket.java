package com.github.moribund.net.packets.key;

import com.github.moribund.net.packets.OutgoingPacket;
import com.github.moribund.objects.playable.Player;
import lombok.Value;

/**
 * Sends a packet to the server to allow for client-server latency of
 * the {@link com.badlogic.gdx.Input.Keys} value pressed by the
 * {@link Player} that owns this client.
 */
@Value
public class KeyPressedPacket implements OutgoingPacket {
    /**
     * The unique player ID of the player that owns this client.
     */
    private int playerId;
    /**
     * The {@link com.badlogic.gdx.Input.Keys} value pressed.
     */
    private int keyPressed;
}

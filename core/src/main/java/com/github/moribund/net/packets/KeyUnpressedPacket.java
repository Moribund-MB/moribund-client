package com.github.moribund.net.packets;

/**
 * Sends a packet to the server to allow for client-server latency of
 * the {@link com.badlogic.gdx.Input.Keys} value released by the
 * {@link com.github.moribund.entity.Player} that owns this client.
 */
public class KeyUnpressedPacket implements Packet {
    /**
     * The unique player ID of the player that owns this client.
     */
    private final int playerId;
    /**
     * The {@link com.badlogic.gdx.Input.Keys} value released.
     */
    private final int keyUnpressed;
    /**
     * The constructor to instantiate the above values.
     * @param playerId The unique player ID.
     * @param keyUnpressed The {@link com.badlogic.gdx.Input.Keys} value released.
     */
    public KeyUnpressedPacket(int playerId, int keyUnpressed) {
        this.playerId = playerId;
        this.keyUnpressed = keyUnpressed;
    }
}

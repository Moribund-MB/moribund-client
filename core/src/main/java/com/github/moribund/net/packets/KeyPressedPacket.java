package com.github.moribund.net.packets;

/**
 * Sends a packet to the server to allow for client-server latency of
 * the {@link com.badlogic.gdx.Input.Keys} value pressed by the
 * {@link com.github.moribund.entity.Player} that owns this client.
 */
public class KeyPressedPacket implements Packet {
    /**
     * The unique player ID of the player that owns this client.
     */
    private final int playerId;
    /**
     * The {@link com.badlogic.gdx.Input.Keys} value pressed.
     */
    private final int keyPressed;

    /**
     * The constructor to instantiate the above values.
     * @param playerId The unique player ID.
     * @param keyPressed The {@link com.badlogic.gdx.Input.Keys} value pressed.
     */
    public KeyPressedPacket(int playerId, int keyPressed) {
        this.playerId = playerId;
        this.keyPressed = keyPressed;
    }
}

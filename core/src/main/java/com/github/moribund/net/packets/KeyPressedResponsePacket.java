package com.github.moribund.net.packets;

import lombok.Getter;

/**
 * The {@link com.badlogic.gdx.Input.Keys} value pressed response back from
 * the server to start moving the player.
 */
public class KeyPressedResponsePacket {
    /**
     * The unique player ID of who pressed the key.
     */
    @Getter
    private int playerId;
    /**
     * The {@link com.badlogic.gdx.Input.Keys} value pressed.
     */
    @Getter
    private int keyPressed;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private KeyPressedResponsePacket() { }
}

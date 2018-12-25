package com.github.moribund.net.packets.key;

import com.github.moribund.net.packets.Packet;
import lombok.Getter;

/**
 * The {@link com.badlogic.gdx.Input.Keys} value pressed response back from
 * the server to enact what to do when the key is pressed.
 */
public class KeyPressedResponsePacket implements Packet {
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

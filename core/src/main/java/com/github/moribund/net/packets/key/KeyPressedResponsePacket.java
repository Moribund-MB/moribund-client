package com.github.moribund.net.packets.key;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import lombok.Getter;
import lombok.val;

/**
 * The {@link com.badlogic.gdx.Input.Keys} value pressed response back from
 * the server to enact what to do when the key is pressed.
 */
public class KeyPressedResponsePacket implements IncomingPacket {
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

    @Override
    public void process() {
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        player.keyPressed(keyPressed);
    }
}

package com.github.moribund.net.packets;

// note: only sent if it is a viable key that is applicable to a player
public class KeyPressedPacket {
    private final int playerId;
    private final int keyPressed;

    public KeyPressedPacket(int playerId, int keyPressed) {
        this.playerId = playerId;
        this.keyPressed = keyPressed;
    }
}

package com.github.moribund.net.packets;

public class KeyUnpressedPacket {
    private final int playerId;
    private final int keyUnpressed;

    public KeyUnpressedPacket(int playerId, int keyUnpressed) {
        this.playerId = playerId;
        this.keyUnpressed = keyUnpressed;
    }
}

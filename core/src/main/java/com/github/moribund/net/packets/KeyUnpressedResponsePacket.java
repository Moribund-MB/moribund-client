package com.github.moribund.net.packets;

import lombok.Getter;

public class KeyUnpressedResponsePacket implements Packet {
    @Getter
    private int playerId;
    @Getter
    private int keyUnpressed;

    private KeyUnpressedResponsePacket() { }
}

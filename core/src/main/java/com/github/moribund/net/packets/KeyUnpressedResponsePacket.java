package com.github.moribund.net.packets;

import lombok.Getter;

public class KeyUnpressedResponsePacket {
    @Getter
    private int playerId;
    @Getter
    private int keyUnpressed;

    private KeyUnpressedResponsePacket() { }
}

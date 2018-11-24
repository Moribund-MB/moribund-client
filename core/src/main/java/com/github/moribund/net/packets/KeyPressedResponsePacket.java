package com.github.moribund.net.packets;

import lombok.Getter;

public class KeyPressedResponsePacket {
    @Getter
    private int playerId;
    @Getter
    private int keyPressed;

    private KeyPressedResponsePacket() { }
}

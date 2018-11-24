package com.github.moribund.net.packets;

public class MovingPacket {
    private final int direction;
    private final int playerId;

    public MovingPacket(int direction, int playerId) {
        this.direction = direction;
        this.playerId = playerId;
    }
}
package com.github.moribund.net.packets.combat;

import com.github.moribund.net.packets.IncomingPacket;

public class DeathPacket implements IncomingPacket {
    private int playerId;

    private DeathPacket() { }

    @Override
    public void process() {
        
    }
}

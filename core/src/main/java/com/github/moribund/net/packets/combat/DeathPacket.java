package com.github.moribund.net.packets.combat;

import com.github.moribund.net.packets.IncomingPacket;
import lombok.Value;

@Value
public class DeathPacket implements IncomingPacket {
    private int playerId;

    @Override
    public void process() {
        
    }
}

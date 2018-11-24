package com.github.moribund.net;

import com.esotericsoftware.kryonet.Client;

public class PacketDispatcher {
    private final Client client;

    PacketDispatcher(Client client) {
        this.client = client;
    }

    public void sendTCP(Object object) {
        client.sendTCP(object);
    }
}

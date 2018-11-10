package com.github.moribund;

import com.badlogic.gdx.Game;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.github.moribund.net.TextListener;
import com.github.moribund.net.packets.MessagePacket;

import java.io.IOException;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MoribundClient extends Game {
    @Override
    public void create() {
        setScreen(new FirstScreen());

        Client client = new Client();
        client.addListener(new TextListener());
        registerPackets(client.getKryo());

        client.start();
        try {
            client.connect(3000, "localhost", 43594);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerPackets(Kryo kryo) {
        kryo.register(MessagePacket.class);
    }
}
package com.github.moribund;

import com.badlogic.gdx.Game;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.net.TextListener;
import com.github.moribund.net.packets.MessagePacket;
import lombok.Getter;

import java.io.IOException;

/**
 * The {@code MoribundClient} class represents the entire {@link Game} for
 * both graphics and networking.
 */
public class MoribundClient extends Game {
    /**
     * The music player dependency.
     */
    @Getter
    private MusicPlayer musicPlayer;

    /**
     * Sets the visual graphics to its initial state and starts the client
     * to server connection.
     */
    @Override
    public void create() {
        musicPlayer = new MusicPlayer();
        setScreen(new TitleScreen(this));
        //connect();
    }

    /**
     * Connects to the {@link com.esotericsoftware.kryonet.Server} using our
     * {@link Client}. This method registers the packets before starting the
     * {@link com.esotericsoftware.kryonet.Connection}.
     */
    private void connect() {
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

    /**
     * Registers packets that are serialized by {@link Kryo}. Packets
     * are NOT required to implement {@link Kryo} or {@link com.esotericsoftware.kryo.KryoSerializable}.
     * @param kryo The {@link Client}'s {@link Kryo}.
     */
    private void registerPackets(Kryo kryo) {
        kryo.register(MessagePacket.class);
    }

    /**
     * Cleans up all the client for optimal performance after the termination
     * of the game.
     */
    @Override
    public void dispose() {
        super.dispose();
        musicPlayer.dispose();
    }
}
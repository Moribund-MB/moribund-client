package com.github.moribund.net;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.esotericsoftware.kryonet.Client;
import com.github.moribund.net.packets.DrawNewPlayerPacket;
import com.github.moribund.net.packets.LoginPacket;
import com.github.moribund.net.packets.LoginRequestPacket;
import com.github.moribund.util.Reference;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The {@code NetworkBootstrapper} class is responsible for giving the
 * initial instructions to start the networking process and listeners.
 */
public class NetworkBootstrapper {
    /**
     * The timeout timeout time for the initial connection.
     */
    private static final int INITIAL_TIMEOUT = 3000;
    /**
     * The IP address to connect to.
     */
    private static final String IP_ADDRESS = "localhost";
    /**
     * The port to access.
     */
    private static final int PORT = 43594;

    private final Client client;

    public NetworkBootstrapper() {
        client = new Client();
    }

    /**
     * Connects to the {@link com.esotericsoftware.kryonet.Server} using our
     * {@link Client}. This method registers the packets before starting the
     * {@link com.esotericsoftware.kryonet.Connection}.
     */
    public void connect() {
        client.addListener(new MovementListener());
        client.addListener(new AccountListener());
        registerPackets(client.getKryo());

        client.start();
        try {
            client.connect(INITIAL_TIMEOUT, IP_ADDRESS, PORT);
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
        kryo.register(DrawNewPlayerPacket.class);
        kryo.register(LoginPacket.class);
        kryo.register(LoginRequestPacket.class);
        kryo.register(ArrayList.class, new JavaSerializer());
        kryo.register(Pair.class, new JavaSerializer());
        kryo.register(Integer.class, new JavaSerializer());
    }

    public void initializePacketDispatcher(Reference<PacketDispatcher> packetDispatcherReference) {
        packetDispatcherReference.setVariable(new PacketDispatcher(client));
    }
}

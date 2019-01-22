package com.github.moribund.net;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.esotericsoftware.kryonet.Client;
import com.github.moribund.net.packets.account.CreateNewPlayerPacket;
import com.github.moribund.net.packets.account.CreateNewPlayerRequestPacket;
import com.github.moribund.net.packets.account.DrawNewPlayerPacket;
import com.github.moribund.net.packets.account.LogoutPacket;
import com.github.moribund.net.packets.combat.ProjectileCollisionPacket;
import com.github.moribund.net.packets.data.GroundItemData;
import com.github.moribund.net.packets.data.PlayerData;
import com.github.moribund.net.packets.game.GameStatePacket;
import com.github.moribund.net.packets.items.ItemOnItemPacket;
import com.github.moribund.net.packets.items.PickupItemPacket;
import com.github.moribund.net.packets.key.KeyPressedPacket;
import com.github.moribund.net.packets.key.KeyPressedResponsePacket;
import com.github.moribund.net.packets.key.KeyUnpressedPacket;
import com.github.moribund.net.packets.key.KeyUnpressedResponsePacket;
import com.github.moribund.net.packets.login.LoginPacket;
import com.github.moribund.net.packets.login.LoginResponse;
import com.github.moribund.net.packets.login.LoginResponsePacket;
import com.github.moribund.net.packets.movement.LocationPacket;
import com.github.moribund.net.packets.movement.RotationPacket;
import com.github.moribund.objects.nonplayable.items.ItemType;
import it.unimi.dsi.fastutil.objects.ObjectList;
import javafx.util.Pair;
import lombok.Getter;

import java.io.IOException;

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

    /**
     * The {@code KryoNet} connection client.
     */
    @Getter
    private final Client client;

    /**
     * Allows for a creation of the connection client.
     */
    public NetworkBootstrapper() {
        client = new Client();
    }

    /**
     * Connects to the {@link com.esotericsoftware.kryonet.Server} using our
     * {@link Client}. This method registers the packets before starting the
     * {@link com.esotericsoftware.kryonet.Connection}.
     */
    public void connect() throws IOException {
        client.addListener(new ClientListener());
        registerPackets(client.getKryo());

        client.start();
        client.connect(INITIAL_TIMEOUT, IP_ADDRESS, PORT, PORT);
    }

    /**
     * Registers packets that are serialized by {@link Kryo}. Packets
     * are NOT required to implement {@link Kryo} or {@link com.esotericsoftware.kryo.KryoSerializable}.
     * @param kryo The {@link Client}'s {@link Kryo}.
     */
    private void registerPackets(Kryo kryo) {
        kryo.register(DrawNewPlayerPacket.class);
        kryo.register(CreateNewPlayerPacket.class);
        kryo.register(CreateNewPlayerRequestPacket.class);
        kryo.register(ObjectList.class, new JavaSerializer());
        kryo.register(Pair.class, new JavaSerializer());
        kryo.register(Integer.class, new JavaSerializer());
        kryo.register(KeyPressedPacket.class);
        kryo.register(KeyPressedResponsePacket.class);
        kryo.register(KeyUnpressedPacket.class);
        kryo.register(KeyUnpressedResponsePacket.class);
        kryo.register(LocationPacket.class);
        kryo.register(RotationPacket.class);
        kryo.register(GameStatePacket.class);
        kryo.register(LogoutPacket.class);
        kryo.register(LoginPacket.class);
        kryo.register(LoginResponse.class, new JavaSerializer());
        kryo.register(LoginResponsePacket.class);
        kryo.register(ItemType.class, new JavaSerializer());
        kryo.register(GroundItemData.class);
        kryo.register(PlayerData.class);
        kryo.register(PickupItemPacket.class);
        kryo.register(ProjectileCollisionPacket.class);
        kryo.register(ItemOnItemPacket.class);
    }

    /**
     * Creates a new {@link PacketDispatcher} with the {@link NetworkBootstrapper#client}.
     * @return The newly made packet dispatcher.
     */
    public PacketDispatcher createPacketDispatcher() {
        return new PacketDispatcher(client);
    }
}

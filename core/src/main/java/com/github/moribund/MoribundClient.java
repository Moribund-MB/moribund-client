package com.github.moribund;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.github.moribund.audio.MusicContainer;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.graphics.SpriteContainer;
import com.github.moribund.graphics.drawables.DrawableGameAsset;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.net.NetworkBootstrapper;
import com.github.moribund.net.PacketDispatcher;
import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.nonplayable.items.GroundItem;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import com.github.moribund.screens.login.LoginScreen;
import com.github.moribund.screens.login.LoginScreenState;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

/**
 * The {@code MoribundClient} class represents the entire {@link Game} for
 * both graphics and networking.
 */
public class MoribundClient extends Game {
    /**
     * The singleton instance of the client for all classes to access.
     */
    private static MoribundClient instance;

    /**
     * All the {@link PlayableCharacter}s in the game.
     */
    @Getter
    private final Int2ObjectMap<PlayableCharacter> players;
    @Getter
    private final ObjectList<GroundItem> groundItems;
    @Getter
    private final ObjectList<DrawableGameAsset> drawableGameAssets;
    @Getter
    private final ObjectList<DrawableUIAsset> drawableUIAssets;
    @Getter
    private final ObjectList<Flaggable> flaggables;
    /**
     * The network bootstrapper to start networking.
     */
    private final NetworkBootstrapper networkBootstrapper;
    /**
     * The dispatcher to send packets to the server.
     */
    private final PacketDispatcher packetDispatcher;
    /**
     * The {@link PlayableCharacter} that the user of this client is.
     */
    @Getter @Setter
    private PlayableCharacter player;

    /**
     * Constructor that provides the {@code MoribundClient} its dependencies.
     * @param networkBootstrapper The network bootstrapper to start networking.
     * @param packetDispatcher The packet dispatcher to send the server packets.
     */
    MoribundClient(NetworkBootstrapper networkBootstrapper,
                   PacketDispatcher packetDispatcher) {
        this.networkBootstrapper = networkBootstrapper;
        this.packetDispatcher = packetDispatcher;
        players = new Int2ObjectOpenHashMap<>();
        drawableGameAssets = new ObjectArrayList<>();
        drawableUIAssets = new ObjectArrayList<>();
        flaggables = new ObjectArrayList<>();
        groundItems = new ObjectArrayList<>();
    }

    /**
     * Instantiates the {@link SpriteContainer} and {@link MusicContainer},
     * connects us to the {@link com.esotericsoftware.kryonet.Server}, then
     * sets the screen to the {@link com.github.moribund.screens.title.TitleScreen}.
     */
    @Override
    public void create() {
        val initialScreen = new LoginScreen(new MusicPlayer(), LoginScreenState.INPUT);

        //connectNetworking();
        SpriteContainer.getInstance().setup();
        MusicContainer.getInstance().setup();
        switchToScreen(initialScreen, true);
    }

    /**
     * Switches the screen to a new {@link Screen}.
     * @param screen The screen to switch to.
     * @param disposePreviousScreen If the previous screen should be disposed. Note: If this is false, the previous
     *                              screen's {@link Screen#hide()} method will still be invoked!
     */
    public void switchToScreen(Screen screen, boolean disposePreviousScreen) {
        if (this.screen != null && disposePreviousScreen) {
            this.screen.dispose();
        }
        setScreen(screen);
    }

    /**
     * Note: Do NOT use this method to switch screens. Instead, use
     * {@link MoribundClient#switchToScreen(Screen, boolean)}!
     */
    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
    }

    /**
     * Connects the client to the {@link com.esotericsoftware.kryonet.Server}.
     */
    public void connectNetworking() {
        networkBootstrapper.connect();
    }

    public void terminateNetworking() {
        networkBootstrapper.getClient().close();
    }

    /**
     * Gets the singleton instance of the client.
     * @return The singleton instance.
     */
    public static MoribundClient getInstance() {
        if (instance == null) {
            val moribundClientFactory = new MoribundClientFactory();
            instance = moribundClientFactory.createMoribundClient();
        }
        return instance;
    }

    /**
     * Gets the packet dispatcher.
     * @return The packet dispatcher.
     */
    public PacketDispatcher getPacketDispatcher() {
        return packetDispatcher;
    }
}
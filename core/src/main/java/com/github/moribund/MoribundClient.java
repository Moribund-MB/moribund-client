package com.github.moribund;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.github.moribund.audio.MusicContainer;
import com.github.moribund.images.SpriteContainer;
import com.github.moribund.net.NetworkBootstrapper;
import com.github.moribund.net.PacketDispatcher;
import com.github.moribund.objects.attributes.Drawable;
import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.playable.PlayableCharacter;
import com.github.moribund.screens.ScreenFactory;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
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
    private final ObjectList<Drawable> drawables;
    @Getter
    private final ObjectList<Flaggable> flaggables;
    /**
     * The factory to make the title screen.
     */
    private final ScreenFactory screenFactory;
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
     * @param players The list of players in the entire game.
     * @param networkBootstrapper The network bootstrapper to start networking.
     * @param packetDispatcher The packet dispatcher to send the server packets.
     * @param screenFactory The screen factory to create the title screen.
     */
    MoribundClient(Int2ObjectMap<PlayableCharacter> players,
                           ObjectList<Drawable> drawables,
                           ObjectList<Flaggable> flaggables,
                           NetworkBootstrapper networkBootstrapper,
                           PacketDispatcher packetDispatcher,
                           ScreenFactory screenFactory) {
        this.players = players;
        this.drawables = drawables;
        this.flaggables = flaggables;
        this.networkBootstrapper = networkBootstrapper;
        this.packetDispatcher = packetDispatcher;
        this.screenFactory = screenFactory;
    }

    /**
     * Instantiates the {@link SpriteContainer} and {@link MusicContainer},
     * connects us to the {@link com.esotericsoftware.kryonet.Server}, then
     * sets the screen to the {@link com.github.moribund.screens.title.TitleScreen}.
     */
    @Override
    public void create() {
        connectNetworking();
        SpriteContainer.getInstance().setup();
        MusicContainer.getInstance().setup();
        switchToScreen(screenFactory, true);
    }

    /**
     * Switches the screen to a new {@link Screen}.
     * @param screenFactory The screen factory that will create the desired screen.
     * @param disposePreviousScreen If the previous screen should be disposed. Note: If this is false, the previous
     *                              screen's {@link Screen#hide()} method will still be invoked!
     */
    public void switchToScreen(ScreenFactory screenFactory, boolean disposePreviousScreen) {
        if (screen != null && disposePreviousScreen) {
            screen.dispose();
        }
        setScreen(screenFactory.createScreen());
    }

    /**
     * Note: Do NOT use this method to switch screens. Instead, use
     * {@link MoribundClient#switchToScreen(ScreenFactory, boolean)}!
     */
    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
    }

    /**
     * Connects the client to the {@link com.esotericsoftware.kryonet.Server}.
     */
    private void connectNetworking() {
        networkBootstrapper.connect();
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
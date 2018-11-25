package com.github.moribund.screens.title;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.github.moribund.MoribundClient;
import com.github.moribund.audio.MusicFile;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.net.packets.LoginRequestPacket;
import com.github.moribund.screens.ScreenFactory;
import lombok.val;

/**
 * The {@code TitleScreen} class is the first {@link Screen} of the {@link com.badlogic.gdx.Game}
 * that {@link MoribundClient} sets to.
 */
public class TitleScreen implements Screen {

    /**
     * The music player to play cached music.
     */
    private final MusicPlayer musicPlayer;
    /**
     * The factory to create a {@link com.github.moribund.screens.game.GameScreen}.
     */
    private final ScreenFactory gameScreenFactory;

    /**
     * Constructor that provides the {@code TitleScreen} its dependencies.
     * @param musicPlayer The music player dependency.
     * @param gameScreenFactory The game screen factory to make a game screen.
     */
    TitleScreen(MusicPlayer musicPlayer, ScreenFactory gameScreenFactory) {
        this.musicPlayer = musicPlayer;
        this.gameScreenFactory = gameScreenFactory;
    }

    /**
     * The equivalent of {@link Game#create()} where this is run as soon as the
     * {@link Game} shows this screen.
     */
    @Override
    public void show() {
        musicPlayer.play(MusicFile.TITLE_SCREEN, true);
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.T)) {
            val client = MoribundClient.getInstance();
            client.setScreen(gameScreenFactory.createScreen());
            client.getPacketDispatcher().sendTCP(new LoginRequestPacket());
        }
        // Draw your screen here. "delta" is the time since last render in seconds.
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        musicPlayer.dispose();
    }
}
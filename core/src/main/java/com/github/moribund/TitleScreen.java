package com.github.moribund;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.github.moribund.audio.MusicFile;

/**
 * The {@code TitleScreen} class is the first {@link Screen} of the {@link com.badlogic.gdx.Game}
 * that {@link MoribundClient} sets to.
 */
public class TitleScreen implements Screen {
    /**
     * The {@link MoribundClient} dependency to access universal dependencies.
     */
    private final MoribundClient client;

    /**
     * The constructor for the {@code TitleScreen}.
     * @param client The {@link MoribundClient} dependency.
     */
    public TitleScreen(MoribundClient client) {
        this.client = client;
    }

    /**
     * The equivalent of {@link Game#create()} where this is run as soon as the
     * {@link Game} shows this screen.
     */
    @Override
    public void show() {
        client.getMusicPlayer().play(MusicFile.TITLE_SCREEN, true);
    }

    @Override
    public void render(float delta) {
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
        // Destroy screen's assets here.
    }
}
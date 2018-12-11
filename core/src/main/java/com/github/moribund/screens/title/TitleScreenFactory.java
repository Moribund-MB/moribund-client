package com.github.moribund.screens.title;

import com.badlogic.gdx.Screen;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.screens.ScreenFactory;
import com.github.moribund.screens.game.GameScreenFactory;
import lombok.val;

public class TitleScreenFactory implements ScreenFactory {

    @Override
    public Screen createScreen() {
        val musicPlayer = createMusicPlayer();
        val gameScreenFactory = createGameScreenFactory();
        val settingsScreenFactory = createSettingsScreenFactory();
        val privateMatchOptionScreenFactory = createPrivateMatchOptionScreenFactory();
        return new TitleScreen(musicPlayer, gameScreenFactory, settingsScreenFactory, privateMatchOptionScreenFactory);
    }

    /**
     * Creates a factory to make the game screen.
     * @return The newly made factory.
     */
    private ScreenFactory createGameScreenFactory() {
        return new GameScreenFactory();
    }

    private ScreenFactory createSettingsScreenFactory() {
        return new SettingsScreenFactory();
    }

    private ScreenFactory createPrivateMatchOptionScreenFactory() { return new PrivateMatchOptionScreenFactory(); }

    /**
     * Creates a music player to play music.
     * @return The newly made music player.
     */
    private MusicPlayer createMusicPlayer() {
        return new MusicPlayer();
    }

}

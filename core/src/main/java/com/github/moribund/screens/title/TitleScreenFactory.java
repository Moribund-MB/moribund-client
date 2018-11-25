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
        return new TitleScreen(musicPlayer, gameScreenFactory);
    }

    private ScreenFactory createGameScreenFactory() {
        return new GameScreenFactory();
    }

    private MusicPlayer createMusicPlayer() {
        return new MusicPlayer();
    }
}

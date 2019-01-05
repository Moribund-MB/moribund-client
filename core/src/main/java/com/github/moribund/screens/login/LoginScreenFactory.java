package com.github.moribund.screens.login;

import com.badlogic.gdx.Screen;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.screens.ScreenFactory;
import lombok.val;

public class LoginScreenFactory implements ScreenFactory {
    @Override
    public Screen createScreen() {
        val musicPlayer = createMusicPlayer();
        return new LoginScreen(musicPlayer);
    }

    private MusicPlayer createMusicPlayer() {
        return new MusicPlayer();
    }
}

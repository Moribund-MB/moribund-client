package com.github.moribund.screens.login;

import com.badlogic.gdx.Screen;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.screens.ScreenFactory;
import lombok.val;

public class LoginScreenFactory implements ScreenFactory {

    private final LoginScreenState initialLoginScreenState;

    public LoginScreenFactory(LoginScreenState initialLoginScreenState) {
        this.initialLoginScreenState = initialLoginScreenState;
    }

    @Override
    public Screen createScreen() {
        val musicPlayer = createMusicPlayer();
        return new LoginScreen(musicPlayer, initialLoginScreenState);
    }

    private MusicPlayer createMusicPlayer() {
        return new MusicPlayer();
    }
}

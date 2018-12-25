package com.github.moribund.screens.title;

import com.badlogic.gdx.Screen;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.screens.ScreenFactory;
import lombok.val;

public class SettingsScreenFactory implements ScreenFactory {

    @Override
    public Screen createScreen() {
        val titleScreenFactory = new TitleScreenFactory();
        val musicPlayer = new MusicPlayer();
        return new SettingsScreen(titleScreenFactory, musicPlayer);
    }
}

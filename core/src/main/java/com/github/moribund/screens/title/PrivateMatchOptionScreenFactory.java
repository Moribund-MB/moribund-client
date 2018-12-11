package com.github.moribund.screens.title;

import com.badlogic.gdx.Screen;
import com.github.moribund.screens.ScreenFactory;
import lombok.val;

public class PrivateMatchOptionScreenFactory implements ScreenFactory {

    @Override
    public Screen createScreen() {
        val titleScreenFactory = new TitleScreenFactory();
        return new PrivateMatchOptionScreen(titleScreenFactory);
    }
}

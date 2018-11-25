package com.github.moribund.screens;

import com.badlogic.gdx.Screen;

/**
 * The {@code ScreenFactory} makes new {@link Screen}s given
 * the dependencies they require.
 */
public interface ScreenFactory {
    /**
     * Creates a {@link Screen} and its dependencies.
     * @return The newly made {@link Screen}.
     */
    Screen createScreen();
}

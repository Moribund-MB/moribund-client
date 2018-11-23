package com.github.moribund.audio;

import dagger.Component;

/**
 * The {@code MusicComponent} uses Dagger 2's {@link Component} system to
 * generate a music player dependency.
 */
@MusicScope
@Component(modules = MusicModule.class)
public interface MusicComponent {
    /**
     * The {@link MusicPlayer} dependency getter.
     * @return The {@link MusicPlayer} dependency
     */
    MusicPlayer getMusicPlayer();
}

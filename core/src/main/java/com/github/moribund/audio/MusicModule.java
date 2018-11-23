package com.github.moribund.audio;

import dagger.Module;
import dagger.Provides;

/**
 * The {@code MusicModule} is a {@link Module} of the {@link MusicComponent}
 * {@link dagger.Component}. This holds the dependency instantiation of the
 * respective music modules.
 */
@Module
public class MusicModule {
    /**
     * The {@link MusicPlayer} provided for the user of this module.
     * @return The {@link MusicPlayer} instanced for this module.
     */
    @Provides
    @MusicScope
    public MusicPlayer musicPlayer() {
        return new MusicPlayer();
    }
}

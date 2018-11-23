package com.github.moribund.audio;

import dagger.Module;
import dagger.Provides;

@Module
public class MusicModule {
    @Provides
    @MusicScope
    public MusicPlayer musicPlayer() {
        return new MusicPlayer();
    }
}

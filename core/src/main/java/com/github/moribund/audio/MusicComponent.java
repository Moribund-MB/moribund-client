package com.github.moribund.audio;

import dagger.Component;

@MusicScope
@Component(modules = MusicModule.class)
public interface MusicComponent {
    MusicPlayer getMusicPlayer();
}

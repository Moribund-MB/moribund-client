package com.github.moribund.images;

import dagger.Module;
import dagger.Provides;

@Module
public class SpriteModule {
    @Provides
    @SpriteScope
    public SpriteDrawer spriteDrawer() {
        return new SpriteDrawer();
    }
}

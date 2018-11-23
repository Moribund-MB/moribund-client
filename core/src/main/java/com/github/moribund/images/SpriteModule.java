package com.github.moribund.images;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dagger.Module;
import dagger.Provides;

@Module
public class SpriteModule {
    @Provides
    @SpriteScope
    public SpriteBatch spriteBatch() {
        return new SpriteBatch();
    }

    @Provides
    @SpriteScope
    public SpriteDrawer spriteDrawer() {
        return new SpriteDrawer();
    }
}

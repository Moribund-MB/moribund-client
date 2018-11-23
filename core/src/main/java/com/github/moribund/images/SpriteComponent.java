package com.github.moribund.images;

import com.github.moribund.GameScreen;
import dagger.Component;

@SpriteScope
@Component(modules = SpriteModule.class)
public interface SpriteComponent {
    void inject(GameScreen gameScreen);
    void inject(SpriteDrawer spriteDrawer);
}

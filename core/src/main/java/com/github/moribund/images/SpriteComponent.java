package com.github.moribund.images;

import dagger.Component;

@SpriteScope
@Component(modules = SpriteModule.class)
public interface SpriteComponent {
    SpriteDrawer getSpriteDrawer();
}

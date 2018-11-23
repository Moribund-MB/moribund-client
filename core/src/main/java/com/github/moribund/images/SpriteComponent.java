package com.github.moribund.images;

import com.github.moribund.GameScreen;
import dagger.Component;

/**
 * The {@code SpriteComponent} uses Dagger 2's {@link Component} system to
 * generate a the sprite dependencies. This differs to, for example,
 * {@link com.github.moribund.audio.MusicComponent} as it allows for the
 * {@link javax.inject.Inject} annotation by providing multiple {@code inject}
 * methods for the respective classes using this component.
 */
@SpriteScope
@Component(modules = SpriteModule.class)
public interface SpriteComponent {
    /**
     * This method allows for injection of the {@link GameScreen} class.
     * @param gameScreen The given {@link GameScreen} class.
     */
    void inject(GameScreen gameScreen);
    /**
     * This method allows for injection of the {@link SpriteDrawer} class.
     * @param spriteDrawer The given {@link SpriteDrawer} class.
     */
    void inject(SpriteDrawer spriteDrawer);
}

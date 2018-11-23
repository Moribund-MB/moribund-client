package com.github.moribund.images;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dagger.Module;
import dagger.Provides;

/**
 * The {@code SpriteModule} is a {@link Module} of the {@link SpriteComponent}
 * {@link dagger.Component}. This holds the dependency instantiation of the
 * respective sprite dependencies.
 */
@Module
public class SpriteModule {
    /**
     * The {@link SpriteBatch} provided for the user of this module.
     * @return The {@link SpriteBatch} instanced for this module.
     */
    @Provides
    @SpriteScope
    public SpriteBatch spriteBatch() {
        return new SpriteBatch();
    }

    /**
     * The {@link SpriteDrawer} provided for the user of this module.
     * @return The {@link SpriteDrawer} instanced for this module.
     * @apiNote This method <i>may</i> be subject to change due to the circular
     * dependency on {@link SpriteBatch}.
     */
    @Provides
    @SpriteScope
    public SpriteDrawer spriteDrawer() {
        return new SpriteDrawer();
    }
}

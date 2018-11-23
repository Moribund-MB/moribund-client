package com.github.moribund.images;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The singleton {@code SpriteScope} that allows for memory saving
 * and practicality of the {@link SpriteComponent} by keeping one
 * instance of the respective {@link SpriteModule}s.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface SpriteScope {
}

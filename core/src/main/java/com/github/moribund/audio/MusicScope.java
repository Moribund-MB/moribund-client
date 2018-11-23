package com.github.moribund.audio;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The singleton {@code MusicScope} that allows for memory saving
 * and practicality of the {@link MusicComponent} by keeping one
 * instance of the respective {@link MusicModule}s.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MusicScope {
}

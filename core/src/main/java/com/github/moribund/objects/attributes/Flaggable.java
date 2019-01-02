package com.github.moribund.objects.attributes;

/**
 * A {code Flaggable} object is an object that has {@link com.github.moribund.objects.flags.Flag}s.
 * All {@code Flaggable}s that wish to have their flags enacted on go to the
 * {@link com.github.moribund.MoribundClient#flaggables} {@link it.unimi.dsi.fastutil.objects.ObjectList}.
 */
public interface Flaggable {
    /**
     * Processes players flags per LibGDX game cycle.
     */
    void processFlags();
}

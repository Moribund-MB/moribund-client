package com.github.moribund.objects.flags;

import com.github.moribund.objects.attributes.Flaggable;

/**
 * A {@code Flag} is a signification of something that is currently happening to a {@link Flaggable}. The reason
 * a flagging system is in place is to allow for a decoupling of input logic being directly correlative to action,
 * but rather allowing a median between the two to allow for non-playable objects to also have the same actions
 * enacted on them.
 */
public interface Flag {
    /**
     * The processing of the flag should it be in the {@link Flaggable}s list of {@code Flag}s.
     * @param flaggable The {@link Flaggable} object that this flag is enacting on.
     */
    void processFlag(Flaggable flaggable);
}

package com.github.moribund.objects.flags.movement;

import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.attributes.RestrictedMovable;
import com.github.moribund.objects.flags.Flag;

/**
 * The {@link com.github.moribund.objects.flags.Flag} that signifies that a {@link RestrictedMovable} is moving upwards.
 */
public class MoveUpFlag implements Flag {
    @Override
    public void processFlag(Flaggable flaggable) {
        if (flaggable instanceof RestrictedMovable) {
            RestrictedMovable movable = (RestrictedMovable) flaggable;
            movable.moveUp();
        }
    }
}

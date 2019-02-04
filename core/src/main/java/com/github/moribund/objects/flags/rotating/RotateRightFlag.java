package com.github.moribund.objects.flags.rotating;

import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.attributes.FluidMovable;
import com.github.moribund.objects.attributes.Movable;
import com.github.moribund.objects.flags.Flag;

/**
 * The {@link com.github.moribund.objects.flags.Flag} that signifies that a {@link Movable} is rotating rightwards.
 */
public class RotateRightFlag implements Flag {
    @Override
    public void processFlag(Flaggable flaggable) {
        if (flaggable instanceof FluidMovable) {
            FluidMovable movable = (FluidMovable) flaggable;
            movable.rotateRight();
        }
    }
}

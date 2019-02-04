package com.github.moribund.objects.flags;

import com.github.moribund.objects.flags.movement.*;
import com.github.moribund.objects.flags.rotating.RotateLeftFlag;
import com.github.moribund.objects.flags.rotating.RotateRightFlag;
import lombok.experimental.UtilityClass;

/**
 * A utility class containing all the {@link Flag}s as ready-to-use constants. These allow for easy removal
 * and adding of flags, for if a new flag were to be made each time, the removal of it from the list of flags
 * would be more complex.
 */
@UtilityClass
public class FlagConstants {
    /**
     * The {@link Flag} that signifies that a {@link com.github.moribund.objects.attributes.FluidMovable} is moving forward.
     */
    public Flag MOVE_FORWARD_FLAG = new MoveForwardFlag();

    /**
     * The {@link Flag} that signifies that a {@link com.github.moribund.objects.attributes.FluidMovable} is moving backwards.
     */
    public Flag MOVE_BACKWARD_FLAG = new MoveBackwardFlag();

    /**
     * The {@link Flag} that signifies that a {@link com.github.moribund.objects.attributes.RestrictedMovable} is moving up.
     */
    public Flag MOVE_UP_FLAG = new MoveUpFlag();

    /**
     * The {@link Flag} that signifies that a {@link com.github.moribund.objects.attributes.RestrictedMovable} is moving down.
     */
    public Flag MOVE_DOWN_FLAG = new MoveDownFlag();

    /**
     * The {@link Flag} that signifies that a {@link com.github.moribund.objects.attributes.RestrictedMovable} is moving left.
     */
    public Flag MOVE_LEFT_FLAG = new MoveLeftFlag();

    /**
     * The {@link Flag} that signifies that a {@link com.github.moribund.objects.attributes.RestrictedMovable} is moving right.
     */
    public Flag MOVE_RIGHT_FLAG = new MoveRightFlag();

    /**
     * The {@link Flag} that signifies that a {@link com.github.moribund.objects.attributes.Movable} is rotating leftwards.
     */
    public Flag ROTATE_LEFT_FLAG = new RotateLeftFlag();

    /**
     * The {@link Flag} that signifies that a {@link com.github.moribund.objects.attributes.Movable} is rotating rightwards.
     */
    public Flag ROTATE_RIGHT_FLAG = new RotateRightFlag();
}

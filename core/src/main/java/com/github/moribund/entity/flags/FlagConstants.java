package com.github.moribund.entity.flags;

import com.github.moribund.entity.flags.movement.MoveBackwardFlag;
import com.github.moribund.entity.flags.movement.MoveForwardFlag;
import com.github.moribund.entity.flags.rotating.RotateLeftFlag;
import com.github.moribund.entity.flags.rotating.RotateRightFlag;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FlagConstants {
    public Flag MOVE_FORWARD_FLAG = new MoveForwardFlag();
    public Flag MOVE_BACKWARD_FLAG = new MoveBackwardFlag();
    public Flag ROTATE_LEFT_FLAG = new RotateLeftFlag();
    public Flag ROTATE_RIGHT_FLAG = new RotateRightFlag();
}

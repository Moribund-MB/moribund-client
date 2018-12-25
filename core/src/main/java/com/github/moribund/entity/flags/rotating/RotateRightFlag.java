package com.github.moribund.entity.flags.rotating;

import com.github.moribund.entity.PlayableCharacter;

public class RotateRightFlag extends RotateFlag {
    @Override
    public void processFlag(PlayableCharacter playableCharacter) {
        playableCharacter.rotateRight();
        sendRotationPacket(playableCharacter);
    }
}

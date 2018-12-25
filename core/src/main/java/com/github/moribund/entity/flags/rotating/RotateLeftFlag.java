package com.github.moribund.entity.flags.rotating;

import com.github.moribund.entity.PlayableCharacter;

public class RotateLeftFlag extends RotateFlag {
    @Override
    public void processFlag(PlayableCharacter playableCharacter) {
        playableCharacter.rotateLeft();
        sendRotationPacket(playableCharacter);
    }
}

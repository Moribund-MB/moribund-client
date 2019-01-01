package com.github.moribund.objects.flags.rotating;

import com.github.moribund.objects.PlayableCharacter;

public class RotateRightFlag extends RotateFlag {
    @Override
    public void processFlag(PlayableCharacter playableCharacter) {
        playableCharacter.rotateRight();
        sendRotationPacket(playableCharacter);
    }
}

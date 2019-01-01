package com.github.moribund.objects.flags.rotating;

import com.github.moribund.objects.PlayableCharacter;

public class RotateLeftFlag extends RotateFlag {
    @Override
    public void processFlag(PlayableCharacter playableCharacter) {
        playableCharacter.rotateLeft();
        sendRotationPacket(playableCharacter);
    }
}

package com.github.moribund.objects.flags.movement;

import com.github.moribund.objects.PlayableCharacter;

public class MoveBackwardFlag extends MovementFlag {
    @Override
    public void processFlag(PlayableCharacter playableCharacter) {
        playableCharacter.moveBack();
        sendLocationPacket(playableCharacter);
    }
}

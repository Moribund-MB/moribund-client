package com.github.moribund.entity.flags.movement;

import com.github.moribund.entity.PlayableCharacter;

public class MoveBackwardFlag extends MovementFlag {
    @Override
    public void processFlag(PlayableCharacter playableCharacter) {
        playableCharacter.moveBack();
        sendLocationPacket(playableCharacter);
    }
}

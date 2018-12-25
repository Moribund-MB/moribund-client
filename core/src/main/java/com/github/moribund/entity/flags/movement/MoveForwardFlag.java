package com.github.moribund.entity.flags.movement;

import com.github.moribund.entity.PlayableCharacter;

public class MoveForwardFlag extends MovementFlag {
    @Override
    public void processFlag(PlayableCharacter playableCharacter) {
        playableCharacter.moveForward();
        sendLocationPacket(playableCharacter);
    }
}

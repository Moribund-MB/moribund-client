package com.github.moribund.objects.flags.movement;

import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.attributes.Movable;
import com.github.moribund.objects.playable.PlayableCharacter;

public class MoveForwardFlag extends MovementFlag {
    @Override
    public void processFlag(Flaggable flaggable) {
        if (flaggable instanceof Movable) {
            Movable movable = (Movable) flaggable;
            movable.moveForward();
        }
        if (flaggable instanceof PlayableCharacter) {
            PlayableCharacter playableCharacter = (PlayableCharacter) flaggable;
            sendLocationPacket(playableCharacter);
        }
    }
}

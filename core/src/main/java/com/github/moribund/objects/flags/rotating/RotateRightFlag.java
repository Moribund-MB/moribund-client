package com.github.moribund.objects.flags.rotating;

import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.attributes.Movable;
import com.github.moribund.objects.playable.PlayableCharacter;

public class RotateRightFlag extends RotateFlag {
    @Override
    public void processFlag(Flaggable flaggable) {
        if (flaggable instanceof Movable) {
            Movable movable = (Movable) flaggable;
            movable.rotateRight();
        }
        if (flaggable instanceof PlayableCharacter) {
            PlayableCharacter playableCharacter = (PlayableCharacter) flaggable;
            sendRotationPacket(playableCharacter);
        }
    }
}

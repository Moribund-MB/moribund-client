package com.github.moribund.objects.flags.movement;

import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.attributes.FluidMovable;
import com.github.moribund.objects.playable.players.PlayableCharacter;

/**
 * The {@link com.github.moribund.objects.flags.Flag} that signifies that a {@link FluidMovable} is moving back.
 */
public class MoveBackwardFlag extends MovementFlag {
    @Override
    public void processFlag(Flaggable flaggable) {
        if (flaggable instanceof FluidMovable) {
            FluidMovable movable = (FluidMovable) flaggable;
            movable.moveBack();
        }
        if (flaggable instanceof PlayableCharacter) {
            PlayableCharacter playableCharacter = (PlayableCharacter) flaggable;
            sendLocationPacket(playableCharacter);
        }
    }
}

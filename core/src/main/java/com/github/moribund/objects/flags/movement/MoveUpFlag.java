package com.github.moribund.objects.flags.movement;

import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.attributes.RestrictedMovable;
import com.github.moribund.objects.playable.players.PlayableCharacter;

/**
 * The {@link com.github.moribund.objects.flags.Flag} that signifies that a {@link RestrictedMovable} is moving upwards.
 */
public class MoveUpFlag extends MovementFlag {
    @Override
    public void processFlag(Flaggable flaggable) {
        if (flaggable instanceof RestrictedMovable) {
            RestrictedMovable movable = (RestrictedMovable) flaggable;
            movable.moveUp();
        }
        if (flaggable instanceof PlayableCharacter) {
            PlayableCharacter playableCharacter = (PlayableCharacter) flaggable;
            sendLocationPacket(playableCharacter);
        }
    }
}

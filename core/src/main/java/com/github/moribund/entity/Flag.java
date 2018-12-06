package com.github.moribund.entity;

import com.github.moribund.screens.game.GameScreen;
import lombok.val;

/**
 * A {code Flag} can describe the current state of a {@link PlayableCharacter}.
 * Every {@link PlayableCharacter} contains a {@link java.util.Set} of flags
 * that are enacted on every call to {@link GameScreen#processFlags()}.
 */
public enum Flag {
    /**
     * The flag that the {@link PlayableCharacter} is moving up.
     */
    MOVE_UP {
        @Override
        public void applyToPlayer(PlayableCharacter playableCharacter) {
            val currentTile = playableCharacter.getCurrentTile();
            val newTile = currentTile.transmorphY(PlayableCharacter.SPEED);
            playableCharacter.setTile(newTile);
        }
    },
    /**
     * The flag that the {@link PlayableCharacter} is moving left.
     */
    MOVE_LEFT {
        @Override
        public void applyToPlayer(PlayableCharacter playableCharacter) {
            val currentTile = playableCharacter.getCurrentTile();
            val newTile = currentTile.transmorphX(-PlayableCharacter.SPEED);
            playableCharacter.setTile(newTile);
        }
    },
    /**
     * The flag that the {@link PlayableCharacter} is moving down.
     */
    MOVE_DOWN {
        @Override
        public void applyToPlayer(PlayableCharacter playableCharacter) {
            val currentTile = playableCharacter.getCurrentTile();
            val newTile = currentTile.transmorphY(-PlayableCharacter.SPEED);
            playableCharacter.setTile(newTile);
        }
    },
    /**
     * The flag that the {@link PlayableCharacter} is moving right.
     */
    MOVE_RIGHT {
        @Override
        public void applyToPlayer(PlayableCharacter playableCharacter) {
            val currentTile = playableCharacter.getCurrentTile();
            val newTile = currentTile.transmorphX(PlayableCharacter.SPEED);
            playableCharacter.setTile(newTile);
        }
    };

    /**
     * Applies the given flag to a player. If this method is not overridden,
     * a {@link AbstractMethodError} exception will occur.
     * @param playableCharacter The {@link PlayableCharacter} to apply the {@code Flag} to.
     */
    public void applyToPlayer(PlayableCharacter playableCharacter) {
        throw new AbstractMethodError();
    }
}

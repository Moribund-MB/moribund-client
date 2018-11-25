package com.github.moribund.entity;

import lombok.val;

public enum Flag {
    MOVE_UP {
        @Override
        public void applyToPlayer(PlayableCharacter playableCharacter) {
            val currentTile = playableCharacter.getCurrentTile();
            val newTile = currentTile.transmorphY(1);
            playableCharacter.setTile(newTile);
        }
    },
    MOVE_LEFT {
        @Override
        public void applyToPlayer(PlayableCharacter playableCharacter) {
            val currentTile = playableCharacter.getCurrentTile();
            val newTile = currentTile.transmorphX(-1);
            playableCharacter.setTile(newTile);
        }
    },
    MOVE_DOWN {
        @Override
        public void applyToPlayer(PlayableCharacter playableCharacter) {
            val currentTile = playableCharacter.getCurrentTile();
            val newTile = currentTile.transmorphY(-1);
            playableCharacter.setTile(newTile);
        }
    },
    MOVE_RIGHT {
        @Override
        public void applyToPlayer(PlayableCharacter playableCharacter) {
            val currentTile = playableCharacter.getCurrentTile();
            val newTile = currentTile.transmorphX(1);
            playableCharacter.setTile(newTile);
        }
    };

    public void applyToPlayer(PlayableCharacter playableCharacter) {
        throw new AbstractMethodError();
    }
}

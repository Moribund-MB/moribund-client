package com.github.moribund.objects.playable.players;

/**
 * A {@link PlayerAction} triggered by a {@link com.badlogic.gdx.Input.Keys}
 * value being pressed or lifted.
 */
interface PlayerAction {
    /**
     * The action to perform when the key is pressed.
     */
    void keyPressed();

    /**
     * The action to perform when the key is lifted.
     */
    void keyUnpressed();
}

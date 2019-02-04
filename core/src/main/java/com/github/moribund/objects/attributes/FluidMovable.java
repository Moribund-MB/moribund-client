package com.github.moribund.objects.attributes;

/**
 * A {@code FluidMovable} object is an object that can move with a dependence on its rotation angle. A fluid movable
 * object can only move forward or back, not in a direction that is independent of its current rotational state.
 */
public interface FluidMovable extends Movable {
    /**
     * Rotates the object leftwards.
     */
    void rotateLeft();

    /**
     * Rotates the object rightwards.
     */
    void rotateRight();

    /**
     * Moves the object forward.
     */
    void moveForward();

    /**
     * Moves the object backward.
     */
    void moveBack();
}

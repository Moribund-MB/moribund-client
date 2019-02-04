package com.github.moribund.objects.attributes;

/**
 * A {@code RestrictedMovable} object is an object that can only move up, down, left, or right. This type of
 * object typically has movement independent of its angle.
 */
public interface RestrictedMovable extends Movable {
    /**
     * Moves the object up, not forward. If one wishes to move forward, use a {@link FluidMovable} object.
     */
    void moveUp();

    /**
     * Moves the object down, not back. If one wishes to move backward, use a {@link FluidMovable} object.
     */
    void moveDown();

    /**
     * Moves the object leftwards. This method is not used to rotate the object. If one wishes for such
     * functionality, use a {@link FluidMovable} object.
     */
    void moveLeft();

    /**
     * Moves the object rightwards. This method is not used to rotate the object. If one wishes for such
     * functionality, use a {@link FluidMovable} object.
     */
    void moveRight();
}

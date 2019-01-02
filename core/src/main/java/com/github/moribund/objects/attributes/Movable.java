package com.github.moribund.objects.attributes;

/**
 * A {@code Movable} object is an object that can move from its initial position.
 */
public interface Movable {
    /**
     * Gets the x-coordinate of the {@code Movable}.
     * @return The x-coordinate.
     */
    float getX();

    /**
     * Gets the y-coordinate of the {@code Movable}.
     * @return The y-coordinate.
     */
    float getY();

    /**
     * Sets the x-coordinate of the {@code Movable}.
     */
    void setX(float x);

    /**
     * Sets the y-coordinate of the {@code Movable}.
     */
    void setY(float y);

    /**
     * Sets the rotational angle of the {@code Movable}.
     */
    void setRotation(float angle);

    /**
     * Gets the rotational angle of the {@code Movable}.
     * @return The rotational angle.
     */
    float getRotation();

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

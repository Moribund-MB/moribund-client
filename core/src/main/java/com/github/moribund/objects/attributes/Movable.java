package com.github.moribund.objects.attributes;

/**
 * A {@code Movable} object is an object that can move from its initial position.
 */
public interface Movable extends Locatable {
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
}

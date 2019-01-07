package com.github.moribund.objects.attributes;

public interface Locatable {
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
     * Gets the rotational angle of the {@code Movable}.
     * @return The rotational angle.
     */
    float getRotation();
}

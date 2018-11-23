package com.github.moribund.entity;

import lombok.Data;
import lombok.val;

/**
 * Represents a {@code Coordinate} on the Cartesian coordinate
 * grid of the game. The {@link Data} annotation is used. More
 * info in the link to the annotation.
 */
@Data
public class Coordinate {
    /**
     * The x-coordinate representation.
     */
    private final int x;
    /**
     * The y-coordinate representation.
     */
    private final int y;

    /**
     * The constructor for a Cartesian coordinate.
     * @param x The x-coordinate representation.
     * @param y The y-coordinate representation.
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate transmorph(int x, int y) {
        val newX = this.x + x;
        val newY = this.y + y;
        return new Coordinate(newX, newY);
    }

    public Coordinate transmorphX(int x) {
        return transmorph(x, 0);
    }

    public Coordinate transmorphY(int y) {
        return transmorph(0, y);
    }
}

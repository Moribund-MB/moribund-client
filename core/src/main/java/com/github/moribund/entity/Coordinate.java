package com.github.moribund.entity;

import lombok.Data;

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
}

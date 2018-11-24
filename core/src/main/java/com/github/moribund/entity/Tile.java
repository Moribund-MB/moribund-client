package com.github.moribund.entity;

import javafx.util.Pair;
import lombok.Data;
import lombok.val;

import java.io.Serializable;

/**
 * Represents a {@code Coordinate} on the Cartesian coordinate
 * grid of the game. The {@link Data} annotation is used. More
 * info in the link to the annotation.
 */
@Data
public class Tile implements Serializable {
    private static final long serialVersionUID = 3010849893269236310L;
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
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile transmorph(int x, int y) {
        val newX = this.x + x;
        val newY = this.y + y;
        return new Tile(newX, newY);
    }

    public Tile transmorphX(int x) {
        return transmorph(x, 0);
    }

    public Tile transmorphY(int y) {
        return transmorph(0, y);
    }

    public static Tile pairToCoordinate(Pair<Integer, Integer> coordinatePair) {
        val x = coordinatePair.getKey();
        val y = coordinatePair.getValue();
        return new Tile(x, y);
    }
}

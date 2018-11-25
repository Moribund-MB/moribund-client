package com.github.moribund.entity;

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
    /**
     * The unique serial version UID so that the client and server
     * can send and receive Tiles with the same serialization.
     */
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

    /**
     * Generates a tile given x and y offsets based on the current {@code Tile}.
     * @param x The x offset to give to the {@code Tile}'s x-coordinate.
     * @param y The y offset to give to the {@code Tile}'s x-coordinate.
     * @return The new {@code Tile} with the given offsets.
     */
    public Tile transmorph(int x, int y) {
        val newX = this.x + x;
        val newY = this.y + y;
        return new Tile(newX, newY);
    }

    /**
     * A helper method that singularly transmorphs the x-axis.
     * @param x The x offset to give to the {@code Tile}'s x-coordinate.
     * @return The new {@code Tile} with the given x offset.
     */
    public Tile transmorphX(int x) {
        return transmorph(x, 0);
    }

    /**
     * A helper method that singularly transmorphs the y-axis.
     * @param y The y offset to give to the {@code Tile}'s y-coordinate.
     * @return The new {@code Tile} with the given y offset.
     */
    public Tile transmorphY(int y) {
        return transmorph(0, y);
    }
}

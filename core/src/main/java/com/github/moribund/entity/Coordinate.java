package com.github.moribund.entity;

import lombok.Data;

@Data
public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

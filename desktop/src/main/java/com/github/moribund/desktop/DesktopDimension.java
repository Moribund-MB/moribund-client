package com.github.moribund.desktop;

import lombok.Getter;

/**
 * A {@code DesktopDimension} for a respective dimension (width, height, etc.).
 */
public enum DesktopDimension {
    /**
     * The set width of the desktop application.
     */
    WIDTH(1024),

    /**
     * The set height of the desktop application.
     */
    HEIGHT(768);

    /**
     * The length of the given dimension.
     */
    @Getter
    private final int length;

    /**
     * Constructor for the {@code DesktopDimension} enum value.
     * @param length The length of the given dimension.
     */
    DesktopDimension(int length) {
        this.length = length;
    }
}

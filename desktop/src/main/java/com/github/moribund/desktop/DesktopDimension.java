package com.github.moribund.desktop;

import lombok.Getter;

public enum DesktopDimension {
    WIDTH(1024),
    HEIGHT(768);

    @Getter
    private final int length;

    DesktopDimension(int length) {
        this.length = length;
    }
}

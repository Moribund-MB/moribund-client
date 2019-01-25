package com.github.moribund.graphics.fonts;

import lombok.Getter;

public enum FontFile {
    CODE_BOLD("fonts/code-bold.fnt", "fonts/code-bold.png"),
    CODE_LIGHT("fonts/code-light.fnt", "fonts/code-light.png"),
    ;

    public static final FontFile[] VALUES = values();

    @Getter
    private final String fontFilePath;
    @Getter
    private final String pngFilePath;

    FontFile(String fontFilePath, String pngFilePath) {
        this.fontFilePath = fontFilePath;
        this.pngFilePath = pngFilePath;
    }
}

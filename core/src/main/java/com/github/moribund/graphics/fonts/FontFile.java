package com.github.moribund.graphics.fonts;

import lombok.Getter;

/**
 * The {@code FontFile} points to the FNT and PNG files of a respective font.
 *
 * @apiNote Fonts are generated using Heiro. Heiro will convert a given font type to FNT and PNG (simultaneously)
 *          when exported as a bitmap font.
 */
public enum FontFile {
    /**
     * The CODE-bold font, used for the death timer.
     */
    CODE_BOLD("fonts/code-bold.fnt", "fonts/code-bold.png"),

    CODE_BOLD_2("fonts/code-bold.fnt", "fonts/code-bold.png"),

    /**
     * The CODE-light font, used for the lobby timer.
     */
    CODE_LIGHT("fonts/code-light.fnt", "fonts/code-light.png"),

    CODE_LIGHT_2("fonts/code-light.fnt", "fonts/code-light.png"),
    ;

    /**
     * All the values of the {@code FontFile} enum. This field is here to save memory, as {@link FontFile#values()}
     * won't need to be invoked to make an array.
     */
    public static final FontFile[] VALUES = values();

    /**
     * The path to the FNT file of the font.
     */
    @Getter
    private final String fontFilePath;

    /**
     * The path to the PNG file of the font.
     */
    @Getter
    private final String pngFilePath;

    FontFile(String fontFilePath, String pngFilePath) {
        this.fontFilePath = fontFilePath;
        this.pngFilePath = pngFilePath;
    }
}

package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.graphics.fonts.FontContainer;
import com.github.moribund.graphics.fonts.FontFile;
import lombok.Setter;

/**
 * A visuals for a timer.
 */
// todo a future plan would be to add an interface system to fetch from the list in the MoribundClient class
public class Timer implements DrawableUIAsset {

    /**
     * The x-coordinate of the timer.
     */
    final int x;

    /**
     * The y-coordinate of the timer.
     */
    final int y;

    /**
     * The font of the timer.
     */
    final BitmapFont font;

    /**
     * The text to display for the timer.
     */
    @Setter
    String displayText;

    Timer(FontFile fontFile, int x, int y, float fontSize) {
        this.x = x;
        this.y = y;
        font = FontContainer.getInstance().getFont(fontFile);
        font.getData().setScale(fontSize);
    }

    @Override
    public void draw(Batch batch) {
        if (displayText != null) {
            font.draw(batch, displayText, x, y);
        }
    }
}

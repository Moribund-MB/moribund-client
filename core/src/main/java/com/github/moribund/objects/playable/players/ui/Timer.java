package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.graphics.fonts.FontContainer;
import com.github.moribund.graphics.fonts.FontFile;
import lombok.Setter;

// todo a future plan would be to add an interface system to fetch from the list in the MoribundClient class
public class Timer implements DrawableUIAsset {
    final int x;
    final int y;
    final BitmapFont font;
    @Setter
    String displayText;

    public Timer(FontFile fontFile, int x, int y, float fontSize) {
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

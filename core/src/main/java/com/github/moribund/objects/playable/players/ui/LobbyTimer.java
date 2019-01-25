package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.fonts.FontFile;

public class LobbyTimer extends Timer {

    public LobbyTimer(FontFile fontFile, int x, int y, float fontSize) {
        super(fontFile, x, y, fontSize);
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        font.draw(batch, "Time until game starts...", x - 150, y + 30);
        if (displayText == null) {
            font.draw(batch, "0:30", x, y);
        } else {
            if (displayText.equalsIgnoreCase("00:00")) {
                MoribundClient.getInstance().getDrawableUIAssets().remove(this);
            }
        }
    }
}

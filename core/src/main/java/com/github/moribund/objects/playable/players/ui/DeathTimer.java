package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.graphics.fonts.FontFile;
import com.github.moribund.graphics.sprites.SpriteContainer;
import com.github.moribund.graphics.sprites.SpriteFile;

public class DeathTimer extends Timer {

    private final Sprite stopwatchIcon;

    public DeathTimer(FontFile fontFile, int x, int y, float fontSize) {
        super(fontFile, x, y, fontSize);
        stopwatchIcon = SpriteContainer.getInstance().getSprite(SpriteFile.STOPWATCH_ICON);
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        batch.draw(stopwatchIcon, x - 35, y - 25);
    }
}

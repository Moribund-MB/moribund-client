package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import lombok.Setter;

public class Timer implements DrawableUIAsset {
    private final int x;
    private final int y;
    @Setter
    private String displayText;

    public Timer(int x, int y) { // todo font here
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Batch batch) {

    }
}

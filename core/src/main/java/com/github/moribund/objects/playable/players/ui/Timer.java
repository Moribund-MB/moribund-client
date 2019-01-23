package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import lombok.Setter;

public class Timer implements DrawableUIAsset {
    @Setter
    private String displayText;

    @Override
    public void draw(SpriteBatch spriteBatch) {

    }
}

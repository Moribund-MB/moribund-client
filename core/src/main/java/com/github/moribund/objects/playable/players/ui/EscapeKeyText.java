package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.graphics.fonts.FontContainer;
import com.github.moribund.graphics.fonts.FontFile;

public class EscapeKeyText implements DrawableUIAsset {

    private final BitmapFont font;

    public EscapeKeyText(FontFile fontFile) {
        font = FontContainer.getInstance().getFont(fontFile);
        font.getData().setScale(.5f);
    }

    @Override
    public void draw(Batch spriteBatch) {
        font.draw(spriteBatch, "Click the escape key", 30, Gdx.graphics.getHeight() - 25);
        font.draw(spriteBatch, "to exit the game...", 30, Gdx.graphics.getHeight() - 45);
    }
}

package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.graphics.fonts.FontContainer;
import com.github.moribund.graphics.fonts.FontFile;

/**
 * The "You won!" text interface.
 */
public class VictoryRoyaleText implements DrawableUIAsset {

    /**
     * The username of the player that won.
     */
    private final String username;
    /**
     * The font used to write the "You won!" text.
     */
    private final BitmapFont font;

    public VictoryRoyaleText(String username, FontFile file) {
        this.username = username;
        font = FontContainer.getInstance().getFont(file);
    }

    @Override
    public void draw(Batch spriteBatch) {
        font.draw(spriteBatch, username + " won!", (Gdx.graphics.getWidth() / 2) - 100, Gdx.graphics.getHeight() - 20);
    }
}

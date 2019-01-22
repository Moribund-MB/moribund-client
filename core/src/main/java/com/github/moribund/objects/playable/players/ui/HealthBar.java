package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import lombok.val;

public class HealthBar implements DrawableUIAsset {

    private final PlayableCharacter playableCharacter;
    private Texture greenTexture;
    private Texture redTexture;

    public HealthBar(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
    }

    @Override
    public Sprite getSprite() {
        return null;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        if (greenTexture == null) {
            greenTexture = new Texture(createProceduralPixmap(1, 1, 0, 1, 0));
        }
        if (redTexture == null) {
            redTexture = new Texture(createProceduralPixmap(1, 1, 1, 0, 0));
        }
        val hitpointsPercentage = playableCharacter.getHitpoints() / 100.0;
        spriteBatch.draw(redTexture, 184, 100, 95 * 7, 20);
        spriteBatch.draw(greenTexture, 184, 100, (int) ((95 * 7) * hitpointsPercentage), 20);
    }

    private Pixmap createProceduralPixmap(int width, int height, int r, int g, int b) {
        val pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(r, g, b, 1);
        pixmap.fill();
        return pixmap;
    }
}

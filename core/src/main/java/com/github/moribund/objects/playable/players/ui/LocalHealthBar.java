package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import com.github.moribund.utils.GLUtils;
import lombok.val;

public class LocalHealthBar implements DrawableUIAsset {

    private final PlayableCharacter playableCharacter;

    public LocalHealthBar(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
    }

    @Override
    public Sprite getSprite() {
        return null;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        val hitpointsPercentage = playableCharacter.getHitpoints() / (double) playableCharacter.getMaxHitpoints();
        spriteBatch.draw(GLUtils.getRedTexture(), 184, 100, 95 * 7, 20);
        spriteBatch.draw(GLUtils.getGreenTexture(), 184, 100, (int) ((95 * 7) * hitpointsPercentage), 20);
    }
}

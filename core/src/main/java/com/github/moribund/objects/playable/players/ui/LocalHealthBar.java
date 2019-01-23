package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
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
    public void draw(Batch batch) {
        val hitpointsPercentage = playableCharacter.getHitpoints() / (double) playableCharacter.getMaxHitpoints();
        batch.draw(GLUtils.getRedTexture(), 184, 100, 95 * 7, 20);
        batch.draw(GLUtils.getGreenTexture(), 184, 100, (int) ((95 * 7) * hitpointsPercentage), 20);
    }
}

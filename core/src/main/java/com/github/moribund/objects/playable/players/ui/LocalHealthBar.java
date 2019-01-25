package com.github.moribund.objects.playable.players.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.github.moribund.graphics.drawables.DrawableUIAsset;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import com.github.moribund.utils.GLUtils;
import lombok.val;

/**
 * The visuals for the local health bar.
 */
public class LocalHealthBar implements DrawableUIAsset {

    public static final int X_LOCATION = 184;
    public static final int Y_LOCATION = 100;

    /**
     * The {@link PlayableCharacter} to use for the health bar.
     */
    private final PlayableCharacter playableCharacter;

    public LocalHealthBar(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
    }

    @Override
    public void draw(Batch batch) {
        val hitpointsPercentage = playableCharacter.getHitpoints() / (double) playableCharacter.getMaxHitpoints();
        batch.draw(GLUtils.getRedTexture(), X_LOCATION, Y_LOCATION, 95 * 7, 20);
        batch.draw(GLUtils.getGreenTexture(), X_LOCATION, Y_LOCATION, (int) ((95 * 7) * hitpointsPercentage), 20);
    }
}

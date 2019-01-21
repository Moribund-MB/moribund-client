package com.github.moribund.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;
import lombok.val;

public class SpriteAnimation extends Animation<TextureRegion> {
    @Getter
    private float stateTime;
    private boolean playing;

    SpriteAnimation(float frameDuration, TextureRegion... keyFrames) {
        super(frameDuration, keyFrames);
        playing = true;
    }

    public void drawAnimation(Batch batch, Sprite originalSprite) {
        stateTime += Gdx.graphics.getDeltaTime();
        val currentFrame = getKeyFrame(stateTime, false);
        batch.draw(currentFrame, originalSprite.getX(), originalSprite.getY(), originalSprite.getOriginX(),
                originalSprite.getOriginY(), currentFrame.getRegionWidth(), currentFrame.getRegionHeight(),
                originalSprite.getScaleX(), originalSprite.getScaleY(), originalSprite.getRotation() + 90);
        if (currentFrame == getKeyFrames()[getKeyFrames().length - 1]) {
            playing = false;
        }
    }

    public void end() {
        playing = true;
        stateTime = 0f;
    }

    public boolean isFinished() {
        return !playing;
    }
}

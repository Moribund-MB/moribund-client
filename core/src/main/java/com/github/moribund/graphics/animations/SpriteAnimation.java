package com.github.moribund.graphics.animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import lombok.Getter;
import lombok.val;

/**
 * A custom class for an {@link Animation<TextureRegion>} that keeps track of if the animation is currently playing
 * and allows for post-runnable actions when an animation finished.
 */
public class SpriteAnimation extends Animation<TextureRegion> {

    /**
     * The current time running for the animation.
     */
    @Getter
    private float stateTime;

    /**
     * If the {@code SpriteAnimation} is playing.
     */
    private boolean playing;

    /**
     * The post-runnable action to invoke once the animation has been complete.
     */
    private Runnable whenEnded;

    /**
     * Creates a {@code SpriteAnimation} given a particular duration and the frames.
     * @param frameDuration The value between 0 and 1 for the duration of the animation.
     * @param keyFrames The frames based on the animation.
     */
    SpriteAnimation(float frameDuration, Array<? extends TextureRegion> keyFrames) {
        super(frameDuration, keyFrames);
        playing = true;
    }

    /**
     * Draws a particular animation.
     * @param batch The batch to draw the {@link SpriteAnimation#keyFrames} to.
     * @param originalSprite The original sprite to mock the location and rotation of.
     */
    public void drawAnimation(Batch batch, Sprite originalSprite) {
        stateTime += Gdx.graphics.getDeltaTime();
        val currentFrame = getKeyFrame(stateTime, false);

        batch.draw(currentFrame, originalSprite.getX(), originalSprite.getY(),
                originalSprite.getOriginX(), originalSprite.getOriginY(),
                currentFrame.getRegionWidth(), currentFrame.getRegionHeight(),
                originalSprite.getScaleX(), originalSprite.getScaleY(),
                originalSprite.getRotation());

        if (currentFrame == getKeyFrames()[getKeyFrames().length - 1]) {
            playing = false;
        }
    }

    /**
     * Sets the post-runnable action to perform after the sprite animation is complete.
     * @param runnable The action to perform.
     */
    public void whenEnded(Runnable runnable) {
        whenEnded = runnable;
    }

    /**
     * Completes the animation by resetting all the variables to allow for reusability.
     */
    public void end() {
        if (whenEnded != null) {
            whenEnded.run();
        }
        whenEnded = null;
        playing = true;
        stateTime = 0f;
    }

    public boolean isFinished() {
        return !playing;
    }
}

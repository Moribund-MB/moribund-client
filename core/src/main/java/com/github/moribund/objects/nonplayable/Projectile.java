package com.github.moribund.objects.nonplayable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.github.moribund.objects.attributes.Drawable;
import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.attributes.Movable;
import com.github.moribund.objects.flags.Flag;
import com.github.moribund.objects.flags.FlagConstants;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import lombok.val;

/**
 * A projectile is not a singular {@link com.badlogic.gdx.graphics.g2d.Sprite},
 * rather it is any {@link com.badlogic.gdx.graphics.g2d.Sprite} that is moving
 * and visible in the screen that is not attached to a {@link com.badlogic.gdx.InputProcessor}.
 */
public class Projectile implements Movable, Drawable, Flaggable {

    private final ObjectSet<Flag> flags;
    private final Sprite sprite;
    private final float rotationSpeed;
    private final float movingSpeed;

    public Projectile(Sprite sprite, float startingX, float startingY, float rotationSpeed, float movingSpeed) {
        this.sprite = sprite;
        this.rotationSpeed = rotationSpeed;
        this.movingSpeed = movingSpeed;
        flags = new ObjectArraySet<>();
        flags.add(FlagConstants.MOVE_FORWARD_FLAG);
        sprite.setX(startingX);
        sprite.setY(startingY);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    @Override
    public void processFlags() {
        flags.forEach(flag -> flag.processFlag(this));
    }

    @Override
    public float getX() {
        return sprite.getX();
    }

    @Override
    public float getY() {
        return sprite.getY();
    }

    @Override
    public void setX(float x) {
        sprite.setX(x);
    }

    @Override
    public void setY(float y) {
        sprite.setY(y);
    }

    @Override
    public void setRotation(float angle) {
        sprite.setRotation(angle);
    }

    @Override
    public float getRotation() {
        return sprite.getRotation();
    }

    @Override
    public void rotateLeft() {
        sprite.rotate(-rotationSpeed);
    }

    @Override
    public void rotateRight() {
        sprite.rotate(rotationSpeed);
    }

    @Override
    public void moveForward() {
        val angle = sprite.getRotation();
        val xVelocity = movingSpeed * MathUtils.cosDeg(angle);
        val yVelocity = movingSpeed * MathUtils.sinDeg(angle);

        sprite.translate(xVelocity, yVelocity);
    }

    @Override
    public void moveBack() {
        val angle = sprite.getRotation();
        val xVelocity = -movingSpeed * MathUtils.cosDeg(angle);
        val yVelocity = -movingSpeed * MathUtils.sinDeg(angle);

        sprite.translate(xVelocity, yVelocity);
    }
}

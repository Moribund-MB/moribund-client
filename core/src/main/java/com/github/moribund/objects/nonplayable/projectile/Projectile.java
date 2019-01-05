package com.github.moribund.objects.nonplayable.projectile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.github.moribund.MoribundClient;
import com.github.moribund.objects.attributes.Drawable;
import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.attributes.Movable;
import com.github.moribund.objects.flags.Flag;
import com.github.moribund.objects.flags.FlagConstants;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import lombok.val;

/**
 * A {@code Projectile} is not a singular {@link com.badlogic.gdx.graphics.g2d.Sprite},
 * rather it is any {@link com.badlogic.gdx.graphics.g2d.Sprite} that is moving
 * and visible in the screen that is not attached to a {@link com.badlogic.gdx.InputProcessor}.
 */
public class Projectile implements Movable, Drawable, Flaggable {

    /**
     * The list of {@link Flag} for its {@link Flaggable} attribute.
     */
    private final ObjectSet<Flag> flags;

    /**
     * The sprite of the {@code Projectile}.
     */
    private final Sprite sprite;

    /**
     * The speed at which the {@code Projectile} can rotate left or right.
     */
    private final float rotationSpeed;

    /**
     * The speed at which the {@code Projectile} can move forward or back.
     */
    private final float movementSpeed;

    /**
     * Creates a new {@code Projectile} with a multitude of initial settings. It is important to note that in this
     * constructor, a {@code Projectile} is automatically marked with the {@link FlagConstants#MOVE_FORWARD_FLAG}
     * flag.
     */
    Projectile(Sprite sprite, float startingX, float startingY, float startingAngle, float rotationSpeed, float movementSpeed) {
        this.sprite = sprite;
        this.rotationSpeed = rotationSpeed;
        this.movementSpeed = movementSpeed;
        flags = new ObjectArraySet<>();
        flags.add(FlagConstants.MOVE_FORWARD_FLAG);
        sprite.setX(startingX);
        sprite.setY(startingY);
        sprite.setRotation(startingAngle);
    }

    /**
     * A helper method made for launching projectiles. Rather than making the person who wishes to launch a projectile
     * go through the hassle of adding the projectile to the list of {@link Flaggable} and {@link Drawable} objects,
     * this helper method takes the projectile and does it for them.
     * @param projectile The respective {@code Projectile} that is about to be launched.
     */
    public static void launchProjectile(Projectile projectile) {
        MoribundClient.getInstance().getFlaggables().add(projectile);
        MoribundClient.getInstance().getDrawables().add(projectile);
    }

    /**
     * Calls the {@link ProjectileBuilder} as an API to construct a {@code Projectile}.
     * @return The newly created {@link ProjectileBuilder}.
     */
    public static ProjectileBuilder builder() {
        return new ProjectileBuilder();
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
        val xVelocity = movementSpeed * MathUtils.cosDeg(angle);
        val yVelocity = movementSpeed * MathUtils.sinDeg(angle);

        sprite.translate(xVelocity, yVelocity);
    }

    @Override
    public void moveBack() {
        val angle = sprite.getRotation();
        val xVelocity = -movementSpeed * MathUtils.cosDeg(angle);
        val yVelocity = -movementSpeed * MathUtils.sinDeg(angle);

        sprite.translate(xVelocity, yVelocity);
    }
}

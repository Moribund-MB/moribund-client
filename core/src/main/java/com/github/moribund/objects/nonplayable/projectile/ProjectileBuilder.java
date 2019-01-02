package com.github.moribund.objects.nonplayable.projectile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.images.SpriteContainer;
import com.github.moribund.images.SpriteFile;

/**
 * The {@code ProjectileBuilder} follows the <a href="https://en.wikipedia.org/wiki/Builder_pattern">Builder pattern</a>
 * to allow for an easy-to-use API to create a rather-complex object: a {@link Projectile}.
 */
public final class ProjectileBuilder {
    private Sprite sprite;
    private float x;
    private float y;
    private float rotationSpeed;
    private float movingSpeed;
    private float angle;

    /**
     * Takes a {@link SpriteFile} and makes a new {@link Sprite} out of it.
     * @param spriteFile The {@link SpriteFile} for the projectile.
     * @return This builder to allow for the building of other attributes.
     */
    public ProjectileBuilder withSprite(SpriteFile spriteFile) {
        sprite = new Sprite(SpriteContainer.getInstance().getSprite(spriteFile));
        return this;
    }

    /**
     * Takes in x and y coordinates to start the {@link Projectile} at initially.
     * @param x The initial x-coordinate.
     * @param y The initial y-coordinate.
     * @return This builder to allow for the building of other attributes.
     */
    public ProjectileBuilder atXY(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Takes in an angle to start the {@link Projectile} at initially.
     * @param angle The initial angle of rotation.
     * @return This builder to allow for the building of other attributes.
     */
    public ProjectileBuilder withAngle(float angle) {
        this.angle = angle;
        return this;
    }

    /**
     * Takes in a speed for the {@link Projectile} to move at. This is in pixels per cycle.
     * @param movementSpeed The movement speed of the {@link Projectile}.
     * @return This builder to allow for the building of other attributes.
     */
    public ProjectileBuilder withMovementSpeed(float movementSpeed) {
        this.movingSpeed = movementSpeed;
        return this;
    }

    /**
     * Takes in a speed for the {@link Projectile} to move at. This is in angles per cycle.
     * @param rotationSpeed The rotation speed of the {@link Projectile}.
     * @return This builder to allow for the building of other attributes.
     */
    public ProjectileBuilder withRotationSpeed(float rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
        return this;
    }

    /**
     * Creates the {@link Projectile} with the given configurations above.
     * @return The newly created {@link Projectile}.
     */
    public Projectile create() {
        return new Projectile(sprite, x, y, angle, rotationSpeed, movingSpeed);
    }
}

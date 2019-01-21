package com.github.moribund.objects.nonplayable.projectile;

import com.github.moribund.graphics.drawables.DrawableGameAsset;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectSet;

import java.io.InvalidObjectException;

/**
 * The {@code ProjectileBuilder} follows the <a href="https://en.wikipedia.org/wiki/Builder_pattern">Builder pattern</a>
 * to allow for an easy-to-use API to create a rather-complex object: a {@link Projectile}.
 */
public final class ProjectileBuilder {
    private float x = -1;
    private float y = -1;
    private float rotationSpeed;
    private float movingSpeed = -1;
    private float angle = -1;
    private ObjectSet<DrawableGameAsset> ignores;
    private ProjectileType projectileType;

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

    public ProjectileBuilder ignoring(DrawableGameAsset ignore) {
        if (ignores == null) {
            ignores = new ObjectArraySet<>();
        }
        ignores.add(ignore);
        return this;
    }

    public ProjectileBuilder type(ProjectileType projectileType) {
        this.projectileType = projectileType;
        return this;
    }

    /**
     * Creates the {@link Projectile} with the given configurations above.
     * @return The newly created {@link Projectile}. Returns null if the {@link Projectile} created encounters an
     *         {@link InvalidObjectException}.
     */
    public Projectile create() {
        try {
            if (projectileType == null) {
                throw new InvalidObjectException("Unable to make a Projectile that is typeless");
            }
            if (x == -1) {
                throw new InvalidObjectException("Unable to make a projectile with no x-coordinate");
            }
            if (y == -1) {
                throw new InvalidObjectException("Unable to make a projectile with no x-coordinate");
            }
            if (angle == -1) {
                throw new InvalidObjectException("Unable to make a projectile without an angle");
            }
            if (movingSpeed == -1) {
                throw new InvalidObjectException("Unable to make a Projectile with no moving speed");
            }
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
        return new Projectile(projectileType, x, y, angle, rotationSpeed, movingSpeed, ignores);
    }
}

package com.github.moribund.objects.nonplayable.projectile;

import com.github.moribund.graphics.drawables.DrawableGameAsset;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectSet;

import java.io.InvalidObjectException;

/**
 * The {@code ProjectileBuilder} follows the <a href="https://en.wikipedia.org/wiki/Builder_pattern">Builder pattern</a>
 * to allow for an easy-to-use API to create a rather-complex object: a {@link Projectile}.
 */
public final class ProjectileBuilder {
    private float x;
    private float y;
    private float rotationSpeed;
    private float movingSpeed = -1;
    private float angle;
    private ObjectSet<DrawableGameAsset> ignores;
    private ProjectileType projectileType;
    private PlayableCharacter source;

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
     * The {@link PlayableCharacter} that is the {@link Projectile#source} of the projectile.
     * @param source The source of the projectile.
     * @return This builder to allow for the building of other attributes.
     */
    public ProjectileBuilder by(PlayableCharacter source) {
        this.source = source;
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
     * The {@link DrawableGameAsset}s to ignore. Initiates the ignores field if it is null.
     * @param ignore The {@link DrawableGameAsset} to ignore.
     * @return This builder to allow for the building of other attributes.
     * TODO change this parameter to {@link com.github.moribund.objects.attributes.Collidable}.
     */
    public ProjectileBuilder ignoring(DrawableGameAsset ignore) {
        if (ignores == null) {
            ignores = new ObjectArraySet<>();
        }
        ignores.add(ignore);
        return this;
    }

    /**
     * Sets the {@link ProjectileType} of the projectile.
     * @param projectileType The {@link ProjectileType} of the projectile.
     * @return This builder to allow for the building of other attributes.
     */
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
            if (movingSpeed == -1) {
                throw new InvalidObjectException("Unable to make a Projectile with no moving speed");
            }
            return new Projectile(projectileType, source, x, y, angle, rotationSpeed, movingSpeed, ignores);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
        return null;
    }
}

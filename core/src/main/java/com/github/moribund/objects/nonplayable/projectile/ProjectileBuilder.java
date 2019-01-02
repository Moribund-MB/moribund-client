package com.github.moribund.objects.nonplayable.projectile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.images.SpriteContainer;
import com.github.moribund.images.SpriteFile;

public final class ProjectileBuilder {
    private Sprite sprite;
    private float x;
    private float y;
    private float rotationSpeed;
    private float movingSpeed;
    private float angle;

    public ProjectileBuilder withSprite(SpriteFile spriteFile) {
        sprite = new Sprite(SpriteContainer.getInstance().getSprite(spriteFile));
        return this;
    }

    public ProjectileBuilder atXY(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public ProjectileBuilder withAngle(float angle) {
        this.angle = angle;
        return this;
    }

    public ProjectileBuilder withMovementSpeed(float movementSpeed) {
        this.movingSpeed = movementSpeed;
        return this;
    }

    public ProjectileBuilder withRotationSpeed(float rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
        return this;
    }

    public Projectile create() {
        return new Projectile(sprite, x, y, angle, rotationSpeed, movingSpeed);
    }
}

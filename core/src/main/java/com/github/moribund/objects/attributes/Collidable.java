package com.github.moribund.objects.attributes;

import com.badlogic.gdx.math.Polygon;
import com.github.moribund.objects.nonplayable.projectile.Projectile;

/**
 * A {@code Collidable} entity that can be collided with a {@link Projectile}.
 */
public interface Collidable {

    /**
     * What to do when an entity collides with a {@link Projectile}.
     * @param projectile The projectile the entity collided with.
     */
    void collide(Projectile projectile);

    /**
     * Gets the {@link Polygon} of the entity.
     * @return the {@link Polygon} of the entity.
     */
    Polygon getPolygon();
}

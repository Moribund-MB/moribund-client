package com.github.moribund.objects.attributes;

import com.github.moribund.objects.nonplayable.projectile.Projectile;

public interface Collidable {
    void collide(Projectile projectile);
}

package com.github.moribund.objects.nonplayable.projectile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.graphics.SpriteContainer;
import com.github.moribund.graphics.SpriteFile;
import com.github.moribund.graphics.SpriteVertices;
import lombok.Getter;

public enum ProjectileType {
    ARROW(0, SpriteContainer.getInstance().getSprite(SpriteFile.ARROW_PROJECTILE), SpriteVertices.ARROW_PROJECTILE);

    private static final ProjectileType[] VALUES = values();
    @Getter
    private final int id;
    @Getter
    private final Sprite sprite;
    @Getter
    private final SpriteVertices spriteVertices;

    ProjectileType(int id, Sprite sprite, SpriteVertices spriteVertices) {
        this.id = id;
        this.sprite = sprite;
        this.spriteVertices = spriteVertices;
    }

    public static ProjectileType getForId(int id) {
        for (ProjectileType projectileType : VALUES) {
            if (projectileType.id == id) {
                return projectileType;
            }
        }
        return null;
    }
}

package com.github.moribund.objects.nonplayable.projectile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.graphics.sprites.SpriteContainer;
import com.github.moribund.graphics.sprites.SpriteFile;
import com.github.moribund.graphics.sprites.SpriteVertices;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.Getter;

public enum ProjectileType {
    ARROW(0, SpriteContainer.getInstance().getSprite(SpriteFile.ARROW_PROJECTILE), SpriteVertices.ARROW_PROJECTILE),
    DART(1, SpriteContainer.getInstance().getSprite(SpriteFile.DART_PROJECTILE), SpriteVertices.DART_PROJECTILE),
    SPEAR(2, SpriteContainer.getInstance().getSprite(SpriteFile.SPEAR_PROJECTILE), SpriteVertices.SPEAR_PROJECTILE);

    private static final Int2ObjectMap<ProjectileType> VALUES;
    @Getter
    private final int id;
    @Getter
    private final Sprite sprite;
    @Getter
    private final SpriteVertices spriteVertices;

    static {
        VALUES = new Int2ObjectOpenHashMap<>();
        for (ProjectileType projectileType : values()) {
            VALUES.put(projectileType.getId(), projectileType);
        }
    }

    ProjectileType(int id, Sprite sprite, SpriteVertices spriteVertices) {
        this.id = id;
        this.sprite = sprite;
        this.spriteVertices = spriteVertices;
    }

    public static ProjectileType getForId(int id) {
        return VALUES.get(id);
    }
}

package com.github.moribund.objects.nonplayable.items;

import com.github.moribund.graphics.SpriteFile;
import com.github.moribund.graphics.SpriteVertices;
import lombok.Getter;

public enum EquippedItemType {
    BOW(5, SpriteFile.PLAYER_WITH_BOW, SpriteVertices.PLAYER_WITH_BOW);

    private static final EquippedItemType[] VALUES = values();

    private final int itemId;
    @Getter
    private final SpriteFile spriteFile;
    @Getter
    private final SpriteVertices spriteVertices;

    EquippedItemType(int itemId, SpriteFile spriteFile, SpriteVertices spriteVertices) {
        this.itemId = itemId;
        this.spriteFile = spriteFile;
        this.spriteVertices = spriteVertices;
    }

    public static EquippedItemType getItemType(int itemid) {
        for (EquippedItemType equippedItemType : VALUES) {
            if (equippedItemType.itemId == itemid) {
                return equippedItemType;
            }
        }
        return null;
    }
}

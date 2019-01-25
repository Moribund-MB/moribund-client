package com.github.moribund.objects.nonplayable.items;

import com.github.moribund.graphics.sprites.SpriteFile;
import com.github.moribund.graphics.sprites.SpriteVertices;
import lombok.Getter;

/**
 * All equipped items in association with their {@link SpriteFile} and {@link SpriteVertices}.
 */
public enum EquippedItemType {
    BOW(5, SpriteFile.PLAYER_WITH_BOW, SpriteVertices.PLAYER_WITH_BOW),
    DART(6, SpriteFile.PLAYER_WITH_DART, SpriteVertices.PLAYER_WITH_DART),
    SPEAR(4, SpriteFile.PLAYER_WITH_SPEAR, SpriteVertices.PLAYER_WITH_SPEAR);

    /**
     * TODO convert this to a HashMap for maximized efficiency.
     */
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

    /**
     * Gets the {@code EquippedItemType} given an {@code itemId}.
     * @param itemId The item ID of the item type.
     * @return The {@code EquippedItemType}.
     */
    public static EquippedItemType getItemType(int itemId) {
        for (EquippedItemType equippedItemType : VALUES) {
            if (equippedItemType.itemId == itemId) {
                return equippedItemType;
            }
        }
        return null;
    }
}

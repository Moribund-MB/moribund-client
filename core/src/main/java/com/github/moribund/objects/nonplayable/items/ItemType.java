package com.github.moribund.objects.nonplayable.items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.graphics.sprites.SpriteContainer;
import com.github.moribund.graphics.sprites.SpriteFile;
import lombok.Getter;

/**
 * The item types of an item which contains its IDs and {@link Sprite}s.
 */
public enum ItemType {
    ROCK(0, SpriteContainer.getInstance().getSprite(SpriteFile.ROCK)),
    FEATHER(1, SpriteContainer.getInstance().getSprite(SpriteFile.FEATHER)),
    STICK(2, SpriteContainer.getInstance().getSprite(SpriteFile.STICK)),
    STRING(3, SpriteContainer.getInstance().getSprite(SpriteFile.STRING)),
    SPEAR(4, SpriteContainer.getInstance().getSprite(SpriteFile.SPEAR)),
    BOW(5, SpriteContainer.getInstance().getSprite(SpriteFile.BOW)),
    DART(6, SpriteContainer.getInstance().getSprite(SpriteFile.DART)),
    ARROW(7, SpriteContainer.getInstance().getSprite(SpriteFile.ARROW_ITEM));

    /**
     * TODO convert this to a HashMap.
     */
    private static final ItemType[] VALUES = values();
    @Getter
    private final int id;
    @Getter
    private final Sprite sprite;

    ItemType(int id, Sprite sprite) {
        this.id = id;
        this.sprite = sprite;
    }

    /**
     * Gets the {@code ItemType} given an {@code id}.
     * @param id The item ID of the item type.
     * @return The {@code ItemType}.
     */
    public static ItemType getItemType(int id) {
        for (ItemType itemType : VALUES) {
            if (itemType.id == id) {
                return itemType;
            }
        }
        return null;
    }
}

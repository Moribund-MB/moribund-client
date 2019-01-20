package com.github.moribund.objects.nonplayable.items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.github.moribund.graphics.SpriteContainer;
import com.github.moribund.graphics.SpriteFile;
import lombok.Getter;

public enum ItemType {
    ROCK(0, SpriteContainer.getInstance().getSprite(SpriteFile.ROCK)),
    FEATHER(1, SpriteContainer.getInstance().getSprite(SpriteFile.FEATHER)),
    STICK(2, SpriteContainer.getInstance().getSprite(SpriteFile.STICK)),
    STRING(3, SpriteContainer.getInstance().getSprite(SpriteFile.STRING));

    private static final ItemType[] VALUES = values();
    @Getter
    private final int id;
    @Getter
    private final Sprite sprite;

    ItemType(int id, Sprite sprite) {
        this.id = id;
        this.sprite = sprite;
    }

    public static ItemType getItemType(int id) {
        for (ItemType itemType : VALUES) {
            if (itemType.id == id) {
                return itemType;
            }
        }
        return null;
    }
}

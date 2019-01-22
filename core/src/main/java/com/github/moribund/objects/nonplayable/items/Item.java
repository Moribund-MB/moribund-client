package com.github.moribund.objects.nonplayable.items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.val;

public class Item {
    private final ItemType itemType;

    public Item(ItemType itemType) {
        this.itemType = itemType;
    }

    public void draw(int slot, float startingX, SpriteBatch spriteBatch) {
        val sprite = new Sprite(itemType.getSprite());
        val incrementation = 95;
        val x = startingX + (incrementation * slot) + 20 - 175;
        val y = 20f;
        sprite.setX(x);
        sprite.setY(y);
        sprite.draw(spriteBatch);
    }
}

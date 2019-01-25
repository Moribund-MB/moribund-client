package com.github.moribund.objects.nonplayable.items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import lombok.Getter;
import lombok.val;

/**
 * The {@code Item} in the inventory or equipment.
 */
public class Item {

    /**
     * The respective {@link ItemType} of the item.
     */
    @Getter
    private final ItemType itemType;

    public Item(ItemType itemType) {
        this.itemType = itemType;
    }

    /**
     * Draws an item onto the screen.
     * @param slot The slot ID of the item.
     * @param startingX The starting X coordinate to start drawing the item from, using the slot to readjust.
     * @param batch The batch to draw the item to.
     */
    public void draw(int slot, float startingX, Batch batch) {
        val sprite = new Sprite(itemType.getSprite());
        val incrementation = 95;
        val x = startingX + (incrementation * slot) + 20 - 175;
        val y = 20f;
        sprite.setX(x);
        sprite.setY(y);
        sprite.draw(batch);
    }
}

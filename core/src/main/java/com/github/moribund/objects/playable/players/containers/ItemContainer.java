package com.github.moribund.objects.playable.players.containers;

import com.github.moribund.objects.nonplayable.items.Item;
import com.github.moribund.objects.nonplayable.items.ItemType;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.Getter;

/**
 * An {@code ItemContainer} is a class that contains an {@link ObjectList<Item>}.
 */
public abstract class ItemContainer {

    /**
     * The list of items that are being contained.
     */
    @Getter
    final ObjectList<Item> items;

    ItemContainer() {
        items = new ObjectArrayList<>();
    }

    /**
     * Sets the {@link Item}s using item IDs.
     * @param itemIds The item IDs to make {@link Item}s out of.
     */
    public void setItemIds(ObjectList<Integer> itemIds) {
        items.clear();
        for (int itemId : itemIds) {
            items.add(new Item(ItemType.getItemType(itemId)));
        }
    }
}

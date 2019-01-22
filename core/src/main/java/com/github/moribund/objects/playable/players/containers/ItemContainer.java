package com.github.moribund.objects.playable.players.containers;

import com.github.moribund.objects.nonplayable.items.Item;
import com.github.moribund.objects.nonplayable.items.ItemType;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;

public abstract class ItemContainer {
    final ObjectList<Item> items;

    ItemContainer() {
        items = new ObjectArrayList<>();
    }

    public void setItemIds(ObjectList<Integer> itemIds) {
        items.clear();
        for (int itemId : itemIds) {
            items.add(new Item(ItemType.getItemType(itemId)));
        }
    }
}

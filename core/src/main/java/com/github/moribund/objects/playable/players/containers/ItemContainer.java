package com.github.moribund.objects.playable.players.containers;

import com.github.moribund.objects.nonplayable.items.Item;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;

public abstract class ItemContainer {
    private final int capacity;
    final ObjectList<Item> items;

    public ItemContainer(int capacity) {
        this.capacity = capacity;
        items = new ObjectArrayList<>();
    }

    public boolean hasSpace() {
        return items.size() < capacity;
    }

    public void addItem(Item item) {
        if (items.size() >= capacity) {
            throw new RuntimeException("Cannot add to this Item container as it has exceeded it's capacity.");
        }
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItem(int slot) {
        return items.get(slot);
    }

    public int size() {
        return items.size();
    }
}

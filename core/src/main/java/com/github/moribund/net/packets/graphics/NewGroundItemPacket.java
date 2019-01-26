package com.github.moribund.net.packets.graphics;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.objects.nonplayable.items.GroundItem;
import com.github.moribund.objects.nonplayable.items.ItemType;
import lombok.val;

public final class NewGroundItemPacket implements IncomingPacket {
    /**
     * The item ID of the ground item.
     */
    private int itemId;

    /**
     * The x-coordinate of the ground item.
     */
    private float x;

    /**
     * The y-coordinate of the ground item.
     */
    private float y;

    private NewGroundItemPacket() { }

    @Override
    public void process() {
        val itemType = ItemType.getItemType(itemId);
        if (itemType == null) {
            return;
        }
        val groundItem = new GroundItem(itemType, x, y);
        GroundItem.addGroundItem(groundItem);
    }
}

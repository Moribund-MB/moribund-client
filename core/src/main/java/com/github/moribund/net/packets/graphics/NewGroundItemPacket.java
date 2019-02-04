package com.github.moribund.net.packets.graphics;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.objects.nonplayable.items.GroundItem;
import com.github.moribund.objects.nonplayable.items.ItemType;
import lombok.val;

/**
 * A packet by the server to signify to the client that a new ground item should be spawned visually.
 */
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

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
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

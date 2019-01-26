package com.github.moribund.net.packets.items;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

/**
 * A packet sent by the client telling the server that a user requested to drop an item.
 */
@Value
public class DropItemPacket implements OutgoingPacket {
    /**
     * The game ID of the player dropping.
     */
    private int gameId;

    /**
     * The player ID of the player dropping.
     */
    private int playerId;

    /**
     * The inventory slot ID of the item that is being attempted to be dropped.
     */
    private int inventorySlot;
}

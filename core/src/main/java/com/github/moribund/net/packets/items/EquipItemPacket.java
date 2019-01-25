package com.github.moribund.net.packets.items;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

/**
 * A packet sent by the client telling the server that a user requested to equip an item at a certain inventory slot.
 */
@Value
public class EquipItemPacket implements OutgoingPacket {

    /**
     * The game ID of the player equipping.
     */
    private int gameId;

    /**
     * The player ID of the player equipping.
     */
    private int playerId;

    /**
     * The inventory slot ID of the item that is being attempted to be equipped.
     */
    private int inventorySlot;
}

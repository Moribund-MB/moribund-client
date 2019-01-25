package com.github.moribund.net.packets.items;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

/**
 * A packet sent by the client telling the server that a user requested to unequip an item at a certain inventory slot.
 */
@Value
public class UnequipItemPacket implements OutgoingPacket {

    /**
     * The game ID of the player equipping.
     */
    private int gameId;

    /**
     * The player ID of the player equipping.
     */
    private int playerId;

    /**
     * The slot ID of the equipment the player is attempted to unequip.
     */
    private int equipmentSlot;
}

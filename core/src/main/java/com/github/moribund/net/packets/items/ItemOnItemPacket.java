package com.github.moribund.net.packets.items;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

/**
 * A packet sent by the client telling the server that a user requested to use item on another.
 */
@Value
public class ItemOnItemPacket implements OutgoingPacket {

    /**
     * The game ID of the player.
     */
    private int gameId;

    /**
     * The player ID of the player.
     */
    private int playerId;

    /**
     * The first inventory slot selected.
     */
    private int slotSelected1;

    /**
     * The second inventory slot selected.
     */
    private int slotSelected2;
}

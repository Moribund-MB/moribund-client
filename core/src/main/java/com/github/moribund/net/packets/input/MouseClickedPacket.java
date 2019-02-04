package com.github.moribund.net.packets.input;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

/**
 * The packet by the client to signify to the server that one has clicked the mouse.
 */
@Value
public class MouseClickedPacket implements OutgoingPacket {

    /**
     * The game ID of the player.
     */
    private int gameId;

    /**
     * The player ID of the player in the game.
     */
    private int playerId;
}

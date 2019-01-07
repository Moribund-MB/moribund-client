package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

/**
 * A packet that indicates a player has disconnected. This allows for the server and client to enact the appropriate
 * clearing methods to remove the Player from their data.
 */
@Value
public class LogoutPacket implements OutgoingPacket {
    private int gameId;
    /**
     * The player ID of the player that disconnected.
     */
    private int playerId;
}

package com.github.moribund.net.packets.account;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.OutgoingPacket;
import com.github.moribund.utils.PlayerUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * A packet that indicates a player has disconnected from a game. This allows for the server and client to enact the
 * appropriate clearing methods to remove the Player from their data.
 *
 * @apiNote This does NOT indicate an account has logged out entirely, rather that is has logged out from a certain
 * game session.
 */
@AllArgsConstructor @NoArgsConstructor
public final class ExitGamePacket implements IncomingPacket, OutgoingPacket {
    /**
     * The game ID of the player logging out.
     */
    private int gameId;

    /**
     * The player ID of the player that disconnected.
     */
    private int playerId;

    /**
     * Calls {@link PlayerUtils#deletePlayer(int)} using the above data.
     */
    @Override
    public void process() {
        PlayerUtils.deletePlayer(playerId);

        if (playerId == MoribundClient.getInstance().getPlayer().getPlayerId()) {
            PlayerUtils.switchToNewTitleScreen();
        }
    }
}

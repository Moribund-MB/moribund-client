package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.data.GroundItemData;
import com.github.moribund.net.packets.data.PlayerLocationData;
import com.github.moribund.net.packets.data.PlayerRotationData;
import com.github.moribund.objects.nonplayable.items.GroundItem;
import com.github.moribund.objects.nonplayable.items.ItemType;
import com.github.moribund.objects.playable.players.Player;
import com.github.moribund.utils.PlayerUtils;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.val;

/**
 * The response from the server that a {@link Player}
 * has logged in. This makes the client do instructions by this message's
 * arrival.
 */
public final class CreateNewPlayerPacket implements IncomingPacket {
    private int gameId;
    /**
     * The unique player ID of the one who just logged in.
     */
    private int playerId;
    /**
     * The locations of all the {@link Player}s in the
     * game currently so that they may be rendered to this player logging in.
     */
    private ObjectList<PlayerLocationData> playerLocations;

    /**
     * The rotations of all the {@link Player}s in the
     * game currently so that they may be rendered to this player logging in.
     */
    private ObjectList<PlayerRotationData> playerRotations;

    private ObjectList<GroundItemData> groundItems;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private CreateNewPlayerPacket() { }

    @Override
    public void process() {
        groundItems.forEach(itemData -> {
            val type = ItemType.getItemType(itemData.getItemId());
            val groundItem = new GroundItem(type, itemData.getX(), itemData.getY());
            GroundItem.addGroundItem(groundItem);
        });
        playerLocations.forEach(locationData -> {
            val playerId = locationData.getPlayerId();
            PlayerUtils.makePlayer(gameId, playerId, locationData.getX(), locationData.getY());
        });
        playerRotations.forEach(rotationData -> {
            val playerId = rotationData.getPlayerId();
            PlayerUtils.rotatePlayer(playerId, rotationData.getAngle());
        });
        PlayerUtils.setClientPlayer(playerId);
    }
}

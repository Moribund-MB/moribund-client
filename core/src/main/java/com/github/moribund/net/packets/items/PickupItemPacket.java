package com.github.moribund.net.packets.items;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.OutgoingPacket;
import com.github.moribund.objects.nonplayable.items.GroundItem;
import lombok.val;

/**
 * A packet sent by both the server and the client to handle picking up {@link GroundItem}s.
 */
public final class PickupItemPacket implements OutgoingPacket, IncomingPacket {

    /**
     * The game ID of the player.
     */
    private final int gameId;

    /**
     * The player ID of the player.
     */
    private final int playerId;

    /**
     * The item ID of the item on the ground.
     */
    private final int itemId;

    /**
     * The x-coordinate of the ground item.
     */
    private final float x;

    /**
     * The y-coordinate of the ground item.
     */
    private final float y;

    public PickupItemPacket(int gameId, int playerId, int itemId, float x, float y) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.itemId = itemId;
        this.x = x;
        this.y = y;
    }

    public PickupItemPacket() {
        gameId = -1;
        playerId = -1;
        itemId = -1;
        x = -1;
        y = -1;
    }

    @Override
    public void process() {
        val groundItem = getGroundItem();
        if (groundItem != null) {
            MoribundClient.getInstance().getGroundItems().remove(groundItem);
            MoribundClient.getInstance().getDrawableGameAssets().remove(groundItem);
        }
    }

    /**
     * Gets a ground item using the above fields.
     * @return The ground item found.
     */
    private GroundItem getGroundItem() {
        for (GroundItem groundItem : MoribundClient.getInstance().getGroundItems()) {
            if (groundItem.matches(itemId, x, y)) {
                return groundItem;
            }
        }
        return null;
    }
}

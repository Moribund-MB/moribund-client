package com.github.moribund.net.packets.items;

import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.OutgoingPacket;
import com.github.moribund.objects.nonplayable.items.GroundItem;
import lombok.val;

public class PickupItemPacket implements OutgoingPacket, IncomingPacket {
    private final int gameId;
    private final int playerId;
    private final int itemId;
    private final float x;
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
        val player = MoribundClient.getInstance().getPlayers().get(playerId);
        val groundItem = getGroundItem();
        if (groundItem != null) {
            player.pickupItem(groundItem);
        }
    }

    private GroundItem getGroundItem() {
        for (GroundItem groundItem : MoribundClient.getInstance().getGroundItems()) {
            if (groundItem.matches(itemId, x, y)) {
                return groundItem;
            }
        }
        return null;
    }
}

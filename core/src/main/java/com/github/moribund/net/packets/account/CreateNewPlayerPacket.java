package com.github.moribund.net.packets.account;

import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.net.packets.data.GroundItemData;
import com.github.moribund.net.packets.data.PlayerData;
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
    /**
     * The game ID of the newly made player.
     */
    private int gameId;

    /**
     * The unique player ID of the one who just logged in.
     */
    private int playerId;

    /**
     * The {@link PlayerData} of all the {@link com.github.moribund.objects.playable.players.PlayableCharacter}s in the
     * game.
     */
    private ObjectList<PlayerData> playerData;

    /**
     * The {@link GroundItemData} of all the {@link GroundItem}s in the game.
     */
    private ObjectList<GroundItemData> groundItems;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private CreateNewPlayerPacket() { }

    /**
     * Spawns all ground items, all players, and sets the {@link com.github.moribund.MoribundClient#player} to the
     * {@link CreateNewPlayerPacket#playerId}.
     */
    @Override
    public void process() {
        groundItems.forEach(itemData -> {
            val type = ItemType.getItemType(itemData.getItemId());
            if (type != null) {
                val groundItem = new GroundItem(type, itemData.getX(), itemData.getY());
                GroundItem.addGroundItem(groundItem);
            }
        });
        playerData.forEach(data -> {
            val playerId = data.getPlayerId();
            val player = PlayerUtils.makePlayer(gameId, playerId, data.getUsername(), data.getX(), data.getY(),
                    data.getRotation(), data.getHitpoints());

            player.getEquipment().setItemIds(data.getEquipmentItems());
            player.getInventory().setItemIds(data.getInventoryItems());

            player.updateAppearance();
        });
        PlayerUtils.setClientPlayer(playerId);
    }
}

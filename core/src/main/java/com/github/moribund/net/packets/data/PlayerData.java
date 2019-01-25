package com.github.moribund.net.packets.data;

import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.Getter;

import java.io.Serializable;

/**
 * The data related to {@link com.github.moribund.objects.playable.players.PlayableCharacter}s to transfer via
 * networking.
 */
public class PlayerData implements Serializable {

    /**
     * The serialization version UID, to allow the client and server to share the same serialization compatibility.
     */
    private static final long serialVersionUID = 5508611406619988854L;

    /**
     * The player ID of the player.
     */
    @Getter
    private int playerId;

    /**
     * The username of the player.
     */
    @Getter
    private String username;

    /**
     * The x-coordinate of the player.
     */
    @Getter
    private float x;

    /**
     * The y-coordinate of the player.
     */
    @Getter
    private float y;

    /**
     * The rotation angle of the player.
     */
    @Getter
    private float rotation;

    /**
     * The current hitpoints of the player.
     */
    @Getter
    private int hitpoints;

    /**
     * The inventory item IDs of the respective player.
     */
    @Getter
    private ObjectList<Integer> inventoryItems;

    /**
     * The equipment item IDs of the respective player.
     */
    @Getter
    private ObjectList<Integer> equipmentItems;
}

package com.github.moribund.net.packets.data;

import lombok.Getter;

import java.io.Serializable;

/**
 * The data related to {@link com.github.moribund.objects.nonplayable.items.GroundItem}s to transfer via
 * networking.
 */
public class GroundItemData implements Serializable {

    /**
     * The serialization version UID, to allow the client and server to share the same serialization compatibility.
     */
    private static final long serialVersionUID = 5508611406619988854L;

    /**
     * The item ID of the ground item.
     */
    @Getter
    private int itemId;

    /**
     * The x-coordinate of the ground item.
     */
    @Getter
    private float x;

    /**
     * The y-coordinate of the ground item.
     */
    @Getter
    private float y;
}

package com.github.moribund.net.packets.data;

import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.Getter;

import java.io.Serializable;

public class PlayerData implements Serializable {
    private static final long serialVersionUID = 5508611406619988854L;

    @Getter
    private int playerId;
    @Getter
    private String username;
    @Getter
    private float x;
    @Getter
    private float y;
    @Getter
    private float rotation;
    @Getter
    private int hitpoints;
    @Getter
    private ObjectList<Integer> inventoryItems;
    @Getter
    private ObjectList<Integer> equipmentItems;
}

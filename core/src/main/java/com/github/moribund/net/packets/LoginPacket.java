package com.github.moribund.net.packets;

import com.github.moribund.entity.Tile;
import javafx.util.Pair;
import lombok.Getter;

import java.util.List;

public class LoginPacket {
    @Getter
    private int playerId;
    @Getter
    private List<Pair<Integer, Tile>> playerLocations;
    private LoginPacket() { }
}

package com.github.moribund.net.packets;

import javafx.util.Pair;
import lombok.Getter;

import java.util.List;

public class LoginPacket {
    @Getter
    private int playerId;
    @Getter
    private List<Pair<Integer, Pair<Integer, Integer>>> playerIds;
    private LoginPacket() { }
}

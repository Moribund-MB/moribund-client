package com.github.moribund.net.packets.game;

import javafx.util.Pair;
import lombok.Getter;

import java.util.List;

public class GameStatePacket {
    @Getter
    private List<Pair<Integer, Pair<Float, Float>>> playerLocations;
    @Getter
    private List<Pair<Integer, Float>> playerRotations;

    private GameStatePacket() { }
}

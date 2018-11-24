package com.github.moribund.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

/**
 * The {@code MovementListener} listens to all packets relating
 * to multi-player rendering of movement.
 * @apiNote This listener class is not yet made to work.
 */
public class MovementListener extends Listener {
    @Override
    public void received(Connection connection, Object object) {

    }
}

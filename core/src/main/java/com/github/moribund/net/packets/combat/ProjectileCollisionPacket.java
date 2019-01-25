package com.github.moribund.net.packets.combat;

import com.github.moribund.net.packets.OutgoingPacket;
import lombok.Value;

/**
 * The packet that is created as a result of a projectile collision with a
 * {@link com.github.moribund.objects.attributes.Collidable}.
 */
@Value
public class ProjectileCollisionPacket implements OutgoingPacket {

    /**
     * The game ID of the player collided.
     */
    private int gameId;

    /**
     * The player ID of the player collided.
     */
    private int playerId;

    /**
     * The player ID of the player responsible for the collision.
     */
    private int sourcePlayerId;

    /**
     * The projectile ID of the projectile that hit the player.
     */
    private int projectileId;
}

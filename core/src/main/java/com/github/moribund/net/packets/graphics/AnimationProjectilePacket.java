package com.github.moribund.net.packets.graphics;

import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.animations.Animation;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.objects.nonplayable.projectile.ProjectileType;
import lombok.val;

/**
 * An "animation projectile packet" that is used to make an animation that is performed and a projectile
 * to shoot afterwards.
 */
public class AnimationProjectilePacket implements IncomingPacket {

    /**
     * The player ID of the one animating/shooting.
     */
    private int playerId;

    /**
     * The ID of the animation to animate.
     */
    private int animationId;

    /**
     * The ID of the projectile to shoot in accordance to {@link ProjectileType}.
     */
    private int projectileId;

    /**
     * The velocity of the animation to move at to define {@link com.github.moribund.objects.nonplayable.projectile.Projectile#movementSpeed}.
     */
    private int movementSpeed;

    /**
     * Calls {@link com.github.moribund.objects.playable.players.PlayableCharacter#animateThenLaunch(Animation, ProjectileType, int)}
     */
    @Override
    public void process() {
        val player =  MoribundClient.getInstance().getPlayers().get(playerId);
        val animation = Animation.getForId(animationId);
        val projectile = ProjectileType.getForId(projectileId);

        player.animateThenLaunch(animation, projectile, movementSpeed);
    }
}

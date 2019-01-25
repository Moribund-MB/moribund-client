package com.github.moribund.net.packets.graphics;

import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.animations.Animation;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.objects.nonplayable.projectile.ProjectileType;
import lombok.val;

public class AnimationProjectilePacket implements IncomingPacket {
    private int playerId;
    private int animationId;
    private int projectileId;
    private int movementSpeed;

    @Override
    public void process() {
        val player =  MoribundClient.getInstance().getPlayers().get(playerId);
        val animation = Animation.getForId(animationId);
        val projectile = ProjectileType.getForId(projectileId);

        player.animateThenLaunch(animation, projectile, movementSpeed);
    }
}

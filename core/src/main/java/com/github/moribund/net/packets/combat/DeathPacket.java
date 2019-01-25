package com.github.moribund.net.packets.combat;

import com.badlogic.gdx.Gdx;
import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.screens.title.TitleScreenFactory;
import com.github.moribund.utils.PlayerUtils;
import lombok.val;

public final class DeathPacket implements IncomingPacket {
    /**
     * The player ID of the player that died.
     */
    private int playerId;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private DeathPacket() { }

    @Override
    public void process() {
        PlayerUtils.deletePlayer(playerId);

        if (MoribundClient.getInstance().getPlayer().getPlayerId() == playerId) {
            Gdx.app.postRunnable(() -> {
                val titleScreenFactory = new TitleScreenFactory();
                MoribundClient.getInstance().switchToScreen(titleScreenFactory.createScreen(), true);
            });
        }
    }
}

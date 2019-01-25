package com.github.moribund.net.packets.combat;

import com.badlogic.gdx.Gdx;
import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.screens.title.TitleScreenFactory;
import com.github.moribund.utils.PlayerUtils;
import lombok.val;

public class DeathPacket implements IncomingPacket {
    private int playerId;

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

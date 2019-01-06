package com.github.moribund.net.packets.login;

import com.badlogic.gdx.Gdx;
import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.screens.login.LoginScreen;
import com.github.moribund.screens.login.LoginScreenState;
import com.github.moribund.screens.title.TitleScreen;

public final class LoginResponsePacket implements IncomingPacket {
    private LoginResponse loginResponse;

    private LoginResponsePacket() { }

    @Override
    public void process() {
        if (MoribundClient.getInstance().getScreen() instanceof LoginScreen) {
            LoginScreen loginScreen = (LoginScreen) MoribundClient.getInstance().getScreen();
            switch (loginResponse) {
                case NEW_ACCOUNT:
                case SUCCESS:
                    Gdx.app.postRunnable(() -> MoribundClient.getInstance().switchToScreen(new TitleScreen(loginScreen.getMusicPlayer()), false));
                    break;
                case INCORRECT_PASSWORD:
                    loginScreen.setLoginScreenState(LoginScreenState.INPUT);
                    MoribundClient.getInstance().terminateNetworking();
                    break;
            }
        }
    }
}

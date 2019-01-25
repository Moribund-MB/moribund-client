package com.github.moribund.net.packets.login;

import com.badlogic.gdx.Gdx;
import com.github.moribund.MoribundClient;
import com.github.moribund.net.packets.IncomingPacket;
import com.github.moribund.screens.login.LoginScreen;
import com.github.moribund.screens.login.LoginScreenState;
import com.github.moribund.screens.title.TitleScreen;
import lombok.val;

/**
 * The {@code LoginResponsePacket} handles responses by the login response.
 */
public final class LoginResponsePacket implements IncomingPacket {

    /**
     * The {@link LoginResponse} by the server to the {@link LoginPacket}.
     */
    private LoginResponse loginResponse;

    /**
     * A private constructor to ensure the client cannot unexpectedly send this
     * request to the server.
     */
    private LoginResponsePacket() { }

    @Override
    public void process() {
        if (MoribundClient.getInstance().getScreen() instanceof LoginScreen) {
            LoginScreen loginScreen = (LoginScreen) MoribundClient.getInstance().getScreen();
            switch (loginResponse) {
                case NEW_ACCOUNT:
                case SUCCESS:
                    Gdx.app.postRunnable(() -> {
                        val titleScreen = new TitleScreen(loginScreen.getMusicPlayer(), loginScreen.getBatch(),
                                loginScreen.getBackground(), loginScreen.getCamera());
                        MoribundClient.getInstance().switchToScreen(titleScreen, false);
                    });
                    break;
                case ALREADY_LOGGED_IN:
                case INCORRECT_PASSWORD:
                    loginScreen.setLoginScreenState(LoginScreenState.INPUT);
                    break;
            }
        }
    }
}

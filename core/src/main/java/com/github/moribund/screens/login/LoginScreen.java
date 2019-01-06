package com.github.moribund.screens.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.moribund.MoribundClient;
import com.github.moribund.audio.MusicFile;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.net.packets.login.LoginPacket;
import com.github.moribund.screens.StageFactory;
import com.github.moribund.utils.GLUtils;
import com.github.moribund.utils.StyleUtils;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.Setter;
import lombok.val;

import java.util.Arrays;

public class LoginScreen implements Screen {

    private final MusicPlayer musicPlayer;
    @Setter
    private LoginScreenState loginScreenState;
    private TextField usernameTextField;
    private TextField passwordTextField;
    private Button loginButton;
    private Stage inputStage;
    private Stage attemptStage;

    LoginScreen(MusicPlayer musicPlayer, LoginScreenState loginScreenState) {
        this.musicPlayer = musicPlayer;
        this.loginScreenState = loginScreenState;
        inputStage = createInputStage();
        attemptStage = createAttemptStage();
    }

    @Override
    public void show() {
        musicPlayer.play(MusicFile.TITLE_SCREEN, true);
        addTextFieldListeners();
        addLoginButtonListener();
        inputStage.setKeyboardFocus(usernameTextField);
    }

    private void addLoginButtonListener() {
        loginButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                attemptLogin();
            }
        });
    }

    private void addTextFieldListeners() {
        val tabKey = 9;
        usernameTextField.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch (keycode) {
                    case tabKey:
                    case Input.Keys.ENTER:
                        usernameTextField.next(false);
                        return true;
                }
                return true;
            }
        });
        passwordTextField.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch (keycode) {
                    case Input.Keys.ENTER:
                        attemptLogin();
                        return true;
                    case tabKey:
                        passwordTextField.next(true);
                        return true;
                }
                return true;
            }
        });
    }

    private void attemptLogin() {
        val username = usernameTextField.getText().trim();
        val password = passwordTextField.getText();

        MoribundClient.getInstance().connectNetworking();
        loginScreenState = LoginScreenState.ATTEMPTING;
        MoribundClient.getInstance().getPacketDispatcher().sendUDP(new LoginPacket(username, password));
    }

    private Stage createInputStage() {
        val stageFactory = new StageFactory();
        val stage = stageFactory.createStage(this::createCredentialTextFields, buttons -> {
            loginButton = new TextButton("Login", StyleUtils.getTextButtonStyle());
            buttons.add(loginButton);
        });

        Gdx.input.setInputProcessor(stage);
        return stage;
    }

    private Stage createAttemptStage() {
        val stageFactory = new StageFactory();
        return stageFactory.createStage(actors -> {
            val labelStyle = StyleUtils.getLabelStyle();
            val label = new Label("Attempting to log you in...", labelStyle);
            actors.add(label);
        });
    }

    private void createCredentialTextFields(ObjectList<Actor> textFields) {
        val textFieldStyle = StyleUtils.getTextFieldStyle();

        usernameTextField = new TextField("", textFieldStyle);
        passwordTextField = new TextField("", textFieldStyle);

        usernameTextField.setMessageText("Username");
        passwordTextField.setMessageText("Password");

        passwordTextField.setPasswordMode(true);
        passwordTextField.setPasswordCharacter('x');

        textFields.addAll(Arrays.asList(usernameTextField, passwordTextField));
    }


    @Override
    public void render(float delta) {
        GLUtils.clearGL();
        switch (loginScreenState) {
            case INPUT:
                inputStage.draw();
                break;
            case ATTEMPTING:
                attemptStage.draw();
                break;
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        musicPlayer.dispose();
        inputStage.dispose();
    }
}

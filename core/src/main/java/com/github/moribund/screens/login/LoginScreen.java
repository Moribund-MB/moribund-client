package com.github.moribund.screens.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
import com.github.moribund.utils.AestheticUtils;
import com.github.moribund.utils.GLUtils;
import com.github.moribund.utils.StageUtils;
import com.github.moribund.utils.StyleUtils;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.util.Arrays;

public class LoginScreen implements Screen {

    @Getter
    private final MusicPlayer musicPlayer;
    @Getter
    private final Batch batch;
    @Getter
    private final Sprite background;
    @Getter
    private final Camera camera;
    @Setter
    private LoginScreenState loginScreenState;
    private TextField usernameTextField;
    private TextField passwordTextField;
    private Button loginButton;
    private Stage inputStage;
    private Stage attemptStage;
    private boolean cameraMovingLeft;

    LoginScreen(MusicPlayer musicPlayer, LoginScreenState loginScreenState, Batch batch, Sprite background, Camera camera) {
        this.musicPlayer = musicPlayer;
        this.loginScreenState = loginScreenState;
        this.batch = batch;
        this.background = background;
        this.camera = camera;
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
                attemptLoginIfPossible();
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
                        attemptLoginIfPossible();
                        return true;
                    case tabKey:
                        passwordTextField.next(true);
                        return true;
                }
                return true;
            }
        });
    }

    private void attemptLoginIfPossible() {
        if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            return;
        }
        val username = usernameTextField.getText().trim();
        val password = passwordTextField.getText();

        loginScreenState = LoginScreenState.ATTEMPTING;
        MoribundClient.getInstance().getPacketDispatcher().sendTCP(new LoginPacket(username.toLowerCase(), password));
    }

    private Stage createInputStage() {
        val stage = StageUtils.createStage(this::createCredentialTextFields, buttons -> {
            loginButton = new TextButton("Login", StyleUtils.TEXT_BUTTON_STYLE);
            buttons.add(loginButton);
        });

        Gdx.input.setInputProcessor(stage);
        return stage;
    }

    private Stage createAttemptStage() {
        return StageUtils.createStage(actors -> {
            val labelStyle = StyleUtils.LABEL_STYLE;
            val label = new Label("Attempting to log you in...", labelStyle);
            actors.add(label);
        });
    }

    private void createCredentialTextFields(ObjectList<Actor> textFields) {
        val textFieldStyle = StyleUtils.TEXT_FIELD_STYLE;

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
        AestheticUtils.renderAestheticSetting(camera, batch, background);
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

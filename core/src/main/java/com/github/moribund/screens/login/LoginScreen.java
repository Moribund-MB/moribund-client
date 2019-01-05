package com.github.moribund.screens.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
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
import lombok.val;

import java.util.Arrays;

public class LoginScreen implements Screen {

    private final MusicPlayer musicPlayer;
    private TextField usernameTextField;
    private TextField passwordTextField;
    private Button loginButton;
    private Stage stage;

    LoginScreen(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
        stage = createStage();
    }

    @Override
    public void show() {
        playTitleScreenMusic();
        addTextFieldListeners();
        addLoginButtonListener();
        setActiveTextField();
    }

    private void setActiveTextField() {
        stage.setKeyboardFocus(usernameTextField);
    }

    private void addLoginButtonListener() {
        loginButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                login();
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
                        login();
                        return true;
                    case tabKey:
                        passwordTextField.next(true);
                        return true;
                }
                return true;
            }
        });
    }

    private void login() {
        System.out.println("logging in with " + usernameTextField.getText() + " and " + passwordTextField.getText());
        val username = usernameTextField.getText().trim();
        val password = passwordTextField.getText();
        MoribundClient.getInstance().getPacketDispatcher().sendUDP(new LoginPacket(username, password));
    }

    private Stage createStage() {
        val stageFactory = new StageFactory();
        val stage = stageFactory.createStage(this::createCredentialTextFields, this::createButtons);

        Gdx.input.setInputProcessor(stage);
        return stage;
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

    private void createButtons(ObjectList<Actor> buttons) {
        val textButtonStyle = StyleUtils.getTextButtonStyle();

        loginButton = new TextButton("Login", textButtonStyle);

        buttons.add(loginButton);
    }

    private void playTitleScreenMusic() {
        musicPlayer.play(MusicFile.TITLE_SCREEN, true);
    }


    @Override
    public void render(float delta) {
        GLUtils.clearGL();
        stage.draw();
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
        stage.dispose();
    }
}

package com.github.moribund.screens.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.github.moribund.audio.MusicFile;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.screens.StageFactory;
import com.github.moribund.utils.GLUtils;
import com.github.moribund.utils.StyleUtils;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;

public class LoginScreen implements Screen {

    private final MusicPlayer musicPlayer;
    private TextField usernameTextField;
    private TextField passwordTextField;
    private Button loginButton;
    private Stage stage;

    public LoginScreen(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
        stage = createStage();
    }

    @Override
    public void show() {
        playTitleScreenMusic();
    }

    private Stage createStage() {
        val stageFactory = new StageFactory();
        val stage = stageFactory.createStage(this::createCredentialTextFields, this::createButtons);

        Gdx.input.setInputProcessor(stage);
        return stage;
    }

    private void createCredentialTextFields(ArrayList<Actor> textFields) {
        val textFieldStyle = StyleUtils.getTextFieldStyle();

        usernameTextField = new TextField("", textFieldStyle);
        passwordTextField = new TextField("", textFieldStyle);

        usernameTextField.setMessageText("Username");
        passwordTextField.setMessageText("Password");

        textFields.addAll(Arrays.asList(usernameTextField, passwordTextField));
    }

    private void createButtons(ArrayList<Actor> buttons) {
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

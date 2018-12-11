package com.github.moribund.screens.title;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.moribund.MoribundClient;
import com.github.moribund.screens.StageFactory;
import com.github.moribund.utils.GLUtils;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;

public class PrivateMatchOptionScreen implements Screen {

    private final TitleScreenFactory titleScreenFactory;

    private final Stage stage;
    private TextButton backButton;
    private TextField privateMatchCodeInput;

    public PrivateMatchOptionScreen(TitleScreenFactory titleScreenFactory) {
        this.titleScreenFactory = titleScreenFactory;
        stage = createStage();
    }

    @Override
    public void show() {
        addButtonListeners();
        //addTextFieldListeners();
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

    }

    private void addButtonListeners() {
        addBackButtonListener();
    }

    private void addTextFieldListeners() {
        addPrivateMatchCodeInputListener();
    }

    private void addBackButtonListener() {
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MoribundClient.getInstance().switchToScreen(titleScreenFactory, false);
            }
        });
    }

    private void addPrivateMatchCodeInputListener() {
        privateMatchCodeInput.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });
    }

    private Stage createStage() {
        val stageFactory = new StageFactory();
        val stage = stageFactory.createStage(this::createButtons);


        Gdx.input.setInputProcessor(stage);
        return stage;
    }

    private void createButtons(ArrayList<Button> buttons, TextButton.TextButtonStyle textButtonStyle) {
        val backButtonText = "Back";

        backButton = new TextButton(backButtonText, textButtonStyle);
        buttons.addAll(Arrays.asList(backButton));
    }

    private void createTextFields(ArrayList<TextField> textFields, TextField.TextFieldStyle textFieldStyle) {
        val privateMatchCodePrompt = "Enter Match Code Here";

        privateMatchCodeInput = new TextField(privateMatchCodePrompt, textFieldStyle);
        textFields.addAll(Arrays.asList(privateMatchCodeInput));
    }
}

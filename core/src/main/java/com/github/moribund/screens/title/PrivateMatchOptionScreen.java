package com.github.moribund.screens.title;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.moribund.MoribundClient;
import com.github.moribund.screens.StageFactory;
import com.github.moribund.utils.GLUtils;
import com.github.moribund.utils.StyleUtils;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.val;

import java.util.Arrays;

public class PrivateMatchOptionScreen implements Screen {
    private final Stage stage;
    private final Screen previousScreen;
    private TextButton backButton;
    private TextField privateMatchCodeInput;

    public PrivateMatchOptionScreen(Screen previousScreen) {
        this.previousScreen = previousScreen;
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
                MoribundClient.getInstance().switchToScreen(previousScreen, false);
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

    private void createButtons(ObjectList<Actor> buttons) {
        val textButtonStyle = StyleUtils.getTextButtonStyle();
        val backButtonText = "Back";

        backButton = new TextButton(backButtonText, textButtonStyle);
        buttons.addAll(Arrays.asList(backButton));
    }

    private void createTextFields(ObjectList<Actor> textFields) {
        val textFieldStyle = StyleUtils.getTextFieldStyle();
        val privateMatchCodePrompt = "Enter Match Code Here";

        privateMatchCodeInput = new TextField(privateMatchCodePrompt, textFieldStyle);
        textFields.addAll(Arrays.asList(privateMatchCodeInput));
    }
}
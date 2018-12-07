package com.github.moribund.screens.title;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.moribund.MoribundClient;
import com.github.moribund.screens.StageFactory;
import com.github.moribund.utils.GLUtils;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;

public class SettingsScreen implements Screen {

    private final TitleScreenFactory titleScreenFactory;

    private final Stage stage;
    private TextButton backButton;

    public SettingsScreen(TitleScreenFactory titleScreenFactory) {
        this.titleScreenFactory = titleScreenFactory;
        stage = createStage();
    }

    @Override
    public void show() {
        addButtonListeners();
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
        stage.dispose();
    }

    private void addButtonListeners() {
        addBackButtonLitener();
    }

    private void addBackButtonLitener() {
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MoribundClient.getInstance().switchToScreen(titleScreenFactory, false);
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
}

package com.github.moribund.screens.title;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.moribund.MoribundClient;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.screens.StageFactory;
import com.github.moribund.utils.GLUtils;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;

public class SettingsScreen implements Screen {

    private final TitleScreenFactory titleScreenFactory;

    private final Stage stage;
    private TextButton backButton;
    private Slider audioSlider;

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
        stage.dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private void addButtonListeners() {
        addBackButtonListener();
        addAudioSliderListener();
    }

    private void addBackButtonListener() {
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MoribundClient.getInstance().switchToScreen(titleScreenFactory, false);
            }
        });
    }

    private void addAudioSliderListener() {
        audioSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float sliderValue = audioSlider.getValue();
                MusicPlayer.setVol(sliderValue);
            }
        });

    }

    private Stage createStage() {
        val stageFactory = new StageFactory();
        val stage = stageFactory.createStage(this::createButtons, this::createSlider);


        Gdx.input.setInputProcessor(stage);
        return stage;
    }

    private void createButtons(ArrayList<Button> buttons, TextButton.TextButtonStyle textButtonStyle) {
        val backButtonText = "Back";

        backButton = new TextButton(backButtonText, textButtonStyle);
        buttons.addAll(Arrays.asList(backButton));
    }

    private void createSlider(ArrayList<Slider> sliders, Slider.SliderStyle sliderStyle) {

        float audioMinimumValue = 0;
        float audioMaximumValue = 1;
        float audioStepSize = (float)0.01;

        audioSlider = new Slider(audioMinimumValue, audioMaximumValue, audioStepSize, false, sliderStyle);
        setSliderValue(audioSlider, audioMaximumValue);

        sliders.addAll(Arrays.asList(audioSlider));

    }

    private float setSliderValue(Slider slider, float value)
    {
        audioSlider.setValue(value);
        return value;
    }

}

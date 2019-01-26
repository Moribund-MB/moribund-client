package com.github.moribund.screens.title;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.moribund.MoribundClient;
import com.github.moribund.audio.MusicFile;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.utils.AestheticUtils;
import com.github.moribund.utils.GLUtils;
import com.github.moribund.utils.StageUtils;
import com.github.moribund.utils.StyleUtils;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.val;

import java.util.Arrays;

class SettingsScreen implements Screen {

    private final MusicPlayer musicPlayer;
    private final Batch batch;
    private final Sprite background;
    private final Camera camera;

    private final Stage stage;
    private TextButton backButton;
    private Slider audioSlider;

    SettingsScreen(MusicPlayer musicPlayer, Batch batch, Sprite background, Camera camera) {
        this.musicPlayer = musicPlayer;
        this.batch = batch;
        this.background = background;
        this.camera = camera;
        stage = createStage();
    }

    @Override
    public void show() {
        audioSlider.setValue(musicPlayer.getVolume(MusicFile.TITLE_SCREEN));
        addButtonListeners();
    }

    @Override
    public void render(float delta) {
        GLUtils.clearGL();
        AestheticUtils.renderAestheticSetting(camera, batch, background);
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
                val titleScreen = new TitleScreen(musicPlayer, batch, background, camera);
                MoribundClient.getInstance().switchToScreen(titleScreen, false);
            }
        });
    }

    private void addAudioSliderListener() {
        audioSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float sliderValue = audioSlider.getValue();
                musicPlayer.setVolume(sliderValue);
            }
        });

    }

    private Stage createStage() {
        val stage = StageUtils.createStage(this::createButtons, this::createSlider);

        Gdx.input.setInputProcessor(stage);
        return stage;
    }

    private void createButtons(ObjectList<Actor> buttons) {
        val textButtonStyle = StyleUtils.TEXT_BUTTON_STYLE;
        val backButtonText = "Back";

        backButton = new TextButton(backButtonText, textButtonStyle);
        buttons.addAll(Arrays.asList(backButton));
    }

    private void createSlider(ObjectList<Actor> sliders) {
        val sliderStyle = StyleUtils.SLIDER_STYLE;

        float audioMinimumValue = 0;
        float audioMaximumValue = 1;
        float audioStepSize = (float)0.01;

        audioSlider = new Slider(audioMinimumValue, audioMaximumValue, audioStepSize, false, sliderStyle);
        setSliderValue(audioSlider, audioMaximumValue);

        sliders.addAll(Arrays.asList(audioSlider));
    }

    private void setSliderValue(Slider slider, float value) {
        slider.setValue(value);
    }
}

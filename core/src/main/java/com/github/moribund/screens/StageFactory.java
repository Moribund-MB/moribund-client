package com.github.moribund.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import lombok.val;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class StageFactory {

    public Stage createStage(BiConsumer<ArrayList<Button>, TextButton.TextButtonStyle> createButtons) {
        val stage = new Stage();
        val skin = createSkin();
        val textButtonStyle = createTextButtonStyle(skin);
        val buttonContainer = new ArrayList<Button>();

        createButtons.accept(buttonContainer, textButtonStyle);

        val menuTable = createMenuTable(buttonContainer);
        stage.addActor(menuTable);
        return stage;
    }

    public Stage createStage(BiConsumer<ArrayList<Button>, TextButton.TextButtonStyle> createButtons, BiConsumer<ArrayList<Slider>, Slider.SliderStyle> createSliders) {
        val stage = new Stage();
        val skin = createSkin();
        val textButtonStyle = createTextButtonStyle(skin);
        val sliderStyle = createSliderStyle(skin);
        val sliderContainer = new ArrayList<Slider>();
        val buttonContainer = new ArrayList<Button>();

        createButtons.accept(buttonContainer, textButtonStyle);
        createSliders.accept(sliderContainer, sliderStyle);

        val menuTable = createMenuTable(buttonContainer, sliderContainer);
        stage.addActor(menuTable);
        return stage;
    }

    private Skin createSkin() {
        val skin = new Skin();
        val buttonAtlas = new TextureAtlas(Gdx.files.internal("skins/clean-crispy/skin/clean-crispy-ui.atlas"));

        skin.addRegions(buttonAtlas);
        return skin;
    }

    private Table createMenuTable(ArrayList<Button> buttonContainer, ArrayList<Slider> sliderContainer) {
        val menuTable = new Table();

        for (Button button : buttonContainer) {
            menuTable.add(button);
            menuTable.row();
        }


        //Tried and failed to figure out labels rip
        //Label audioLabel = createLabel(createSkin(), "Audio");
        //menuTable.add(audioLabel);
        //menuTable.row();

        for (Slider slider : sliderContainer)
        {
            menuTable.add(slider);
            menuTable.row();
        }
        menuTable.center();
        menuTable.setFillParent(true);
        return menuTable;
    }

    private Table createMenuTable(ArrayList<Button> buttonContainer) {
        val menuTable = new Table();

        for (Button button : buttonContainer) {
            menuTable.add(button);
            menuTable.row();
        }
        menuTable.center();
        menuTable.setFillParent(true);
        return menuTable;
    }

    private TextButton.TextButtonStyle createTextButtonStyle(Skin skin) {
        val textButtonStyle = new TextButton.TextButtonStyle();

        textButtonStyle.font = new BitmapFont(Gdx.files.internal("skins/clean-crispy/raw/font-export.fnt"));
        textButtonStyle.up = skin.getDrawable("button");
        textButtonStyle.down = skin.getDrawable("button-pressed");
        textButtonStyle.checked = skin.getDrawable(("button-over"));
        return textButtonStyle;
    }

    private Slider.SliderStyle createSliderStyle(Skin skin) {
        val sliderStyle = new Slider.SliderStyle();
        sliderStyle.knob = skin.getDrawable("scrollpane-knob-horizontal");
        sliderStyle.background = skin.getDrawable("scrollpane-horizontal");
        return sliderStyle;
    }

    private Label createLabel(Skin skin, String labelText) {
        Label label = new Label(labelText, skin);
        Label.LabelStyle labelStyle = createLabelStyle();
        label.setStyle(labelStyle);
        return label;
    }

    private Label.LabelStyle createLabelStyle() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont(Gdx.files.internal("skins/clean-crispy/raw/font-export.fnt"));
        return labelStyle;
    }

}

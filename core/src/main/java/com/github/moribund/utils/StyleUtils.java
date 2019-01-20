package com.github.moribund.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import lombok.val;

public final class StyleUtils {
    private static final Skin SKIN = createSkin();
    public static final Slider.SliderStyle SLIDER_STYLE = createSliderStyle();
    public static final TextButton.TextButtonStyle TEXT_BUTTON_STYLE = createTextButtonStyle();
    public static final TextField.TextFieldStyle TEXT_FIELD_STYLE = createTextFieldStyle();
    public static final Label.LabelStyle LABEL_STYLE = createLabelStyle();

    private static final String SKIN_NAME = "medieval";
    private static final String UI_ATLAS_NAME = "medieval";
    private static final String FONT_NAME = "font-export";

    private static TextField.TextFieldStyle createTextFieldStyle() {
        val textFieldStyle = new TextField.TextFieldStyle();

        textFieldStyle.font = new BitmapFont(Gdx.files.internal("skins/" + SKIN_NAME + "/raw/" + FONT_NAME +".fnt"));
        textFieldStyle.fontColor = Color.BLACK;
        textFieldStyle.background = SKIN.getDrawable("buttonlong_beige_pressed");
        return textFieldStyle;
    }

    private static Slider.SliderStyle createSliderStyle() {
        val sliderStyle = new Slider.SliderStyle();

        //sliderStyle.knob = SKIN.getDrawable("scrollpane-knob-horizontal");
        //sliderStyle.background = SKIN.getDrawable("scrollpane-horizontal");
        return sliderStyle;
    }

    private static TextButton.TextButtonStyle createTextButtonStyle() {
        val textButtonStyle = new TextButton.TextButtonStyle();

        textButtonStyle.font = new BitmapFont(Gdx.files.internal("skins/" + SKIN_NAME + "/raw/" + FONT_NAME + ".fnt"));
        textButtonStyle.up = SKIN.getDrawable("buttonlong_brown");
        textButtonStyle.down = SKIN.getDrawable("buttonlong_brown_pressed");
        textButtonStyle.checked = SKIN.getDrawable(("buttonlong_brown"));
        return textButtonStyle;
    }

    private static Label.LabelStyle createLabelStyle() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont(Gdx.files.internal("skins/" + SKIN_NAME + "/raw/" + FONT_NAME + ".fnt"));
        return labelStyle;
    }

    private static Skin createSkin() {
        val skin = new Skin();
        val buttonAtlas = new TextureAtlas(Gdx.files.internal("skins/" + SKIN_NAME + "/skin/" + UI_ATLAS_NAME + ".atlas"));

        skin.addRegions(buttonAtlas);
        return skin;
    }
}

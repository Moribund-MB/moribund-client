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

    private static final String SKIN_NAME = "clean-crispy";
    private static final String UI_ATLAS_NAME = "clean-crispy-ui";
    private static final String FONT_NAME = "font-export";

    //private static final Color TEXT_COLOR = new Color((float).51, (float).32, (float).19, 1);
    //private static final Color SECONDARY_TEXT_COLOR = new Color((float).93, (float).52, (float).26, 1);

    private static TextField.TextFieldStyle createTextFieldStyle() {
        val textFieldStyle = new TextField.TextFieldStyle();

        BitmapFont font = new BitmapFont(Gdx.files.internal("skins/" + SKIN_NAME + "/raw/" + FONT_NAME +".fnt"));
        textFieldStyle.font = font;

        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.messageFontColor = Color.WHITE;
        textFieldStyle.background = SKIN.getDrawable("textfield");
        return textFieldStyle;
    }

    private static Slider.SliderStyle createSliderStyle() {
        val sliderStyle = new Slider.SliderStyle();

        sliderStyle.knob = SKIN.getDrawable("scrollpane-knob-horizontal");
        sliderStyle.background = SKIN.getDrawable("scrollpane-horizontal");
        return sliderStyle;
    }

    private static TextButton.TextButtonStyle createTextButtonStyle() {
        val textButtonStyle = new TextButton.TextButtonStyle();

        textButtonStyle.font = new BitmapFont(Gdx.files.internal("skins/" + SKIN_NAME + "/raw/" + FONT_NAME + ".fnt"));
        textButtonStyle.fontColor = Color.WHITE;
        textButtonStyle.up = SKIN.getDrawable("button");
        textButtonStyle.down = SKIN.getDrawable("button-pressed");
        textButtonStyle.checked = SKIN.getDrawable(("button-over"));
        return textButtonStyle;
    }

    private static Label.LabelStyle createLabelStyle() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont(Gdx.files.internal("skins/" + SKIN_NAME + "/raw/" + FONT_NAME + ".fnt"));
        labelStyle.fontColor = Color.WHITE;
        return labelStyle;
    }

    private static Skin createSkin() {
        val skin = new Skin();
        val buttonAtlas = new TextureAtlas(Gdx.files.internal("skins/" + SKIN_NAME + "/skin/" + UI_ATLAS_NAME + ".atlas"));

        skin.addRegions(buttonAtlas);
        return skin;
    }
}

package com.github.moribund.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import lombok.Getter;
import lombok.val;

public final class StyleUtils {
    @Getter
    private static final Skin skin = createSkin();
    @Getter
    private static final Slider.SliderStyle sliderStyle = createSliderStyle();
    @Getter
    private static final TextButton.TextButtonStyle textButtonStyle = createTextButtonStyle();
    @Getter
    private static final TextField.TextFieldStyle textFieldStyle = createTextFieldStyle();
    @Getter
    private static final Label.LabelStyle labelStyle = createLabelStyle();

    private static TextField.TextFieldStyle createTextFieldStyle() {
        val textFieldStyle = new TextField.TextFieldStyle();

        textFieldStyle.font = new BitmapFont(Gdx.files.internal("skins/clean-crispy/raw/font-export.fnt"));
        textFieldStyle.fontColor = Color.BLACK;
        textFieldStyle.background = skin.getDrawable("textfield");
        return textFieldStyle;
    }

    private static Slider.SliderStyle createSliderStyle() {
        val sliderStyle = new Slider.SliderStyle();

        sliderStyle.knob = skin.getDrawable("scrollpane-knob-horizontal");
        sliderStyle.background = skin.getDrawable("scrollpane-horizontal");
        return sliderStyle;
    }

    private static TextButton.TextButtonStyle createTextButtonStyle() {
        val textButtonStyle = new TextButton.TextButtonStyle();

        textButtonStyle.font = new BitmapFont(Gdx.files.internal("skins/clean-crispy/raw/font-export.fnt"));
        textButtonStyle.up = skin.getDrawable("button");
        textButtonStyle.down = skin.getDrawable("button-pressed");
        textButtonStyle.checked = skin.getDrawable(("button-over"));
        return textButtonStyle;
    }

    private static Label.LabelStyle createLabelStyle() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont(Gdx.files.internal("skins/clean-crispy/raw/font-export.fnt"));
        return labelStyle;
    }

    private static Skin createSkin() {
        val skin = new Skin();
        val buttonAtlas = new TextureAtlas(Gdx.files.internal("skins/clean-crispy/skin/clean-crispy-ui.atlas"));

        skin.addRegions(buttonAtlas);
        return skin;
    }
}

package com.github.moribund.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.val;

import java.util.function.BiConsumer;

public class StageFactory {

    public Stage createStage(BiConsumer<ObjectList<Button>, TextButton.TextButtonStyle> createButtons) {
        val stage = new Stage();
        val skin = createSkin();
        val textButtonStyle = createTextButtonStyle(skin);
        val buttonContainer = new ObjectArrayList<Button>();

        createButtons.accept(buttonContainer, textButtonStyle);

        val menuTable = createMenuTable(buttonContainer);
        stage.addActor(menuTable);
        return stage;
    }

    private Skin createSkin() {
        val skin = new Skin();
        val buttonAtlas = new TextureAtlas(Gdx.files.internal("skins/clean-crispy/skin/clean-crispy-ui.atlas"));

        skin.addRegions(buttonAtlas);
        return skin;
    }

    private Table createMenuTable(ObjectList<Button> buttonContainer) {
        val menuTable = new Table();

        for (Button button : buttonContainer) {
            menuTable.add(button);
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

}

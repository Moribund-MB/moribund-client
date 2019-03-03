package com.github.moribund.screens.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.moribund.MoribundClient;
import com.github.moribund.audio.MusicFile;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.utils.AestheticUtils;
import com.github.moribund.utils.GLUtils;
import com.github.moribund.utils.StageUtils;
import com.github.moribund.utils.StyleUtils;
import lombok.val;

class HowToPlayScreen implements Screen {
    private final MusicPlayer musicPlayer;
    private final Batch batch;
    private final Sprite background;
    private final Camera camera;
    private final Stage stage;
    private Button backButton;

    HowToPlayScreen(MusicPlayer musicPlayer, Batch batch, Sprite background, Camera camera) {
        this.musicPlayer = musicPlayer;
        this.batch = batch;
        this.background = background;
        this.camera = camera;
        stage = createStage();
    }

    private Stage createStage() {
        val stage = StageUtils.createStage(windows -> {
            Dialog dialog = new Dialog("How to Play", StyleUtils.WINDOW_STYLE);
            dialog.text("Moribund is a 2D battle-royale where time is of the essence! When a player is spawned in the game, they\n" +
                    "start with a timer that is counting down to their demise. How do you survive? Kill another person and absorb\n" +
                    "some of their time! Construct your medieval weapons (like shortbows, javelins, and darts) and fend for\n" +
                    "yourself!\n\n" +
                    "Moribund uses WASD keys to move. A and D keys rotate your character, while the W and S keys move your\n" +
                    "player forward or back. To pick up items, use the E key. You shoot your weapon with a left mouse click.\n" +
                    "To equip a weapon, double click it. To unequip it, click it in the equipment slot. To drop a weapon,\n" +
                    "right click the item in your inventory. To exit your current game session, click the escape key!\n\n" +
                    "In order to fend for yourself, you must pick up raw materials and craft your weapons! To craft a weapon, \n" +
                    "use an item on an item! The item combinations are as follows:\n\n" +
                    "- Stick + String = Bow (you cannot shoot a bow without arrows)\n" +
                    "- Stick + Feather = Dart\n" +
                    "- Stick + Rock = Javelin\n" +
                    "- Dart + Rock = Arrows (unlimited amount)\n\n" +
                    "Go forth and claim your superiority with victory!", StyleUtils.LABEL_STYLE);

            backButton = new TextButton("Back", StyleUtils.TEXT_BUTTON_STYLE);
            dialog.button(backButton);
            windows.add(dialog);
        });

        Gdx.input.setInputProcessor(stage);
        return stage;
    }

    private void addExitButtonListener() {
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                val loginScreen = new LoginScreen(musicPlayer, LoginScreenState.INPUT, batch, background, camera);
                MoribundClient.getInstance().switchToScreen(loginScreen, false);
            }
        });
    }

    @Override
    public void show() {
        musicPlayer.play(MusicFile.TITLE_SCREEN, true);
        addExitButtonListener();
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

    }

    @Override
    public void dispose() {

    }
}

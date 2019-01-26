package com.github.moribund.screens.title;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.moribund.MoribundClient;
import com.github.moribund.audio.MusicFile;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.net.packets.account.CreateNewPlayerRequestPacket;
import com.github.moribund.screens.game.GameScreenFactory;
import com.github.moribund.utils.AestheticUtils;
import com.github.moribund.utils.GLUtils;
import com.github.moribund.utils.StageUtils;
import com.github.moribund.utils.StyleUtils;
import it.unimi.dsi.fastutil.objects.ObjectList;
import lombok.val;

import java.util.Arrays;

/**
 * The {@code TitleScreen} class is the first {@link Screen} of the {@link com.badlogic.gdx.Game}
 * that {@link MoribundClient} sets to.
 */
public class TitleScreen implements Screen {

    /**
     * The music player to play cached music.
     */
    private final MusicPlayer musicPlayer;
    private final Batch batch;
    private final Sprite background;
    private final Camera camera;
    private final Stage stage;

    private TextButton findMatchButton, settingsButton, exitButton;

    /**
     * Constructor that provides the {@code TitleScreen} its dependencies.
     * @param musicPlayer The music player dependency.
     */
    public TitleScreen(MusicPlayer musicPlayer, Batch batch, Sprite background, Camera camera) {
        this.musicPlayer = musicPlayer;
        this.batch = batch;
        this.background = background;
        this.camera = camera;
        stage = createStage();
    }

    /**
     * The equivalent of {@link Game#create()} where this is run as soon as the
     * {@link Game} shows this screen.
     */
    @Override
    public void show() {
        musicPlayer.play(MusicFile.TITLE_SCREEN, true);
        addButtonListeners();
    }

    private void addButtonListeners() {
        addFindMatchButtonListener();
        addSettingsButtonListener();
        addExitButtonListener();
    }

    private void addFindMatchButtonListener() {
        findMatchButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                val gameScreenFactory = new GameScreenFactory();
                MoribundClient.getInstance().switchToScreen(gameScreenFactory.createScreen(), true);
                val packetDispatcher = MoribundClient.getInstance().getPacketDispatcher();
                packetDispatcher.sendTCP(new CreateNewPlayerRequestPacket());
            }
        });
    }

    private void addSettingsButtonListener() {
        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                val settingsScreen = new SettingsScreen(musicPlayer, batch, background, camera);
                MoribundClient.getInstance().switchToScreen(settingsScreen, false);
            }
        });
    }

    private void addExitButtonListener() {
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void render(float delta) {
        GLUtils.clearGL();
        AestheticUtils.renderAestheticSetting(camera, batch, background);
        stage.draw();
        // Draw your screen here. "delta" is the time since last render in seconds.
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        musicPlayer.dispose();
        stage.dispose();
    }

    private Stage createStage() {
        val stage = StageUtils.createStage(this::createButtons);

        Gdx.input.setInputProcessor(stage);
        return stage;
    }

    private void createButtons(ObjectList<Actor> buttons) {
        val textButtonStyle = StyleUtils.TEXT_BUTTON_STYLE;

        val findMatchText = "Find Match";
        val settingsText = "Settings";
        val exitText = "Exit";

        findMatchButton = new TextButton(findMatchText, textButtonStyle);
        settingsButton = new TextButton(settingsText, textButtonStyle);
        exitButton = new TextButton(exitText, textButtonStyle);

        buttons.addAll(Arrays.asList(findMatchButton, settingsButton, exitButton));
    }

}
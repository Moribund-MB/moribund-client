package com.github.moribund.screens.title;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.moribund.MoribundClient;
import com.github.moribund.audio.MusicFile;
import com.github.moribund.audio.MusicPlayer;
import com.github.moribund.net.packets.LoginRequestPacket;
import com.github.moribund.screens.ScreenFactory;
import com.github.moribund.screens.StageFactory;
import com.github.moribund.utils.GLUtils;
import lombok.val;

import java.util.ArrayList;
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
    /**
     * The factory to create a {@link com.github.moribund.screens.game.GameScreen}.
     */
    private final ScreenFactory gameScreenFactory;
    private final ScreenFactory settingsScreenFactory;

    private final Stage stage;
    private TextButton findMatchButton, settingsButton, privateMatchButton, exitButton;


    /**
     * Constructor that provides the {@code TitleScreen} its dependencies.
     * @param musicPlayer The music player dependency.
     * @param gameScreenFactory The game screen factory to make a game screen.
     */
    TitleScreen(MusicPlayer musicPlayer, ScreenFactory gameScreenFactory, ScreenFactory settingsScreenFactory) {
        this.musicPlayer = musicPlayer;
        this.gameScreenFactory = gameScreenFactory;
        this.settingsScreenFactory = settingsScreenFactory;
        stage = createStage();
    }

    /**
     * The equivalent of {@link Game#create()} where this is run as soon as the
     * {@link Game} shows this screen.
     */
    @Override
    public void show() {
        playTitleScreenMusic();
        addButtonListeners();
    }

    private void playTitleScreenMusic() {
        musicPlayer.play(MusicFile.TITLE_SCREEN, true);
    }

    private void addButtonListeners() {
        addFindMatchButtonListener();
        addSettingsButtonListener();
    }

    private void addFindMatchButtonListener() {
        findMatchButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MoribundClient.getInstance().switchToScreen(gameScreenFactory);
                val packetDispatcher = MoribundClient.getInstance().getPacketDispatcher();
                packetDispatcher.sendTCP(new LoginRequestPacket());
            }
        });
    }

    private void addSettingsButtonListener() {
        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MoribundClient.getInstance().switchToScreen(settingsScreenFactory);
            }
        });
    }

    @Override
    public void render(float delta) {
        GLUtils.clearGL();
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
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        musicPlayer.dispose();
        stage.dispose();
    }

    private Stage createStage() {
        val stageFactory = new StageFactory();
        val stage = stageFactory.createStage(this::createButtons);

        Gdx.input.setInputProcessor(stage);
        return stage;
    }

    private void createButtons(ArrayList<Button> buttons, TextButton.TextButtonStyle textButtonStyle) {
        val findMatchText = "Find Match";
        val settingsText = "Settings";
        val privateMatchText = "Private Match";
        val exitText = "Exit";

        findMatchButton = new TextButton(findMatchText, textButtonStyle);
        settingsButton = new TextButton(settingsText, textButtonStyle);
        privateMatchButton = new TextButton(privateMatchText, textButtonStyle);
        exitButton = new TextButton(exitText, textButtonStyle);

        buttons.addAll(Arrays.asList(findMatchButton, settingsButton, privateMatchButton, exitButton));
    }

}
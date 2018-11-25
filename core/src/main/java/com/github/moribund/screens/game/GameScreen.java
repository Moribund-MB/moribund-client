package com.github.moribund.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.images.SpriteContainer;
import lombok.val;

public class GameScreen implements Screen {

    /**
     * A shortcut to the {@link MoribundClient}'s sprite batch.
     */
    private final SpriteBatch spriteBatch;
    private final Camera camera;

    GameScreen(SpriteBatch spriteBatch, Camera camera) {
        this.spriteBatch = spriteBatch;
        this.camera = camera;
    }

    /**
     * The equivalent of {@link com.badlogic.gdx.Game#create()} where this
     * is run as soon as this screen is displayed.
     */
    @Override
    public void show() {

    }

    /**
     * Renders the {@link Screen} by clearing the GL and drawing the sprites.
     * Essentially, this is the heart of the game's {@link com.badlogic.gdx.graphics.g2d.Sprite}s.
     *
     * @param delta As of now, unclassified usage.
     */
    @Override
    public void render(float delta) {
        processFlags();
        clearGl();
        drawSpriteBatch(this::drawVisibleEntities);
    }

    /**
     * Draws all the {@link com.github.moribund.entity.PlayableCharacter}'s
     * {@link com.badlogic.gdx.graphics.g2d.Sprite}s.
     */
    private void drawVisibleEntities() {
        MoribundClient.getInstance().getPlayers().forEach((playerId, player) -> player.draw(spriteBatch));
    }

    private void processFlags() {
        val players = MoribundClient.getInstance().getPlayers().values();
        players.forEach(player -> player.getFlags().forEach(flag -> flag.applyToPlayer(player)));
    }

    /**
     * Clears the GL buffer. This program, as proven by imports, uses OpenGL 2.0+.
     */
    private void clearGl() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    /**
     * Draws the {@link SpriteBatch} by enabling it for drawing and taking in
     * the drawing actions of drawing {@link com.badlogic.gdx.graphics.g2d.Sprite}s.
     * It then closes the {@link SpriteBatch}.
     *
     * @param drawing The {@link Runnable} drawing actions (typically using
     *                {@link SpriteContainer} to draw them) executed just before the
     *                {@link SpriteBatch} ends.
     */
    private void drawSpriteBatch(Runnable drawing) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        drawing.run();
        spriteBatch.end();
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
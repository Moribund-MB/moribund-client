package com.github.moribund;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.entity.Coordinate;
import com.github.moribund.images.SpriteDrawer;
import com.github.moribund.images.SpriteFile;

import javax.inject.Inject;

public class GameScreen implements Screen {
    @Inject
    SpriteBatch spriteBatch;
    @Inject
    SpriteDrawer spriteDrawer;

    @Override
    public void show() {
        injectSpriteComponent();
        drawGameFrame();
        drawPlayers();
    }

    private void injectSpriteComponent() {
        MoribundClient.getInstance().getSpriteComponent().inject(this);
    }

    private void drawPlayers() {
        // todo multiplayer
    }

    private void drawGameFrame() {
        // todo draw the game frame
    }

    @Override
    public void render(float delta) {
        clearGl();
        drawSpriteBatch(() -> {
            spriteDrawer.drawSprite(SpriteFile.DUMMY_PLAYER, new Coordinate(50, 100));
        });
    }

    private void clearGl() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void drawSpriteBatch(Runnable drawing) {
        spriteBatch.setProjectionMatrix(MoribundClient.getInstance().getCamera().combined);
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

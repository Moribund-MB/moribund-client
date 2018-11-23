package com.github.moribund;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.github.moribund.entity.Coordinate;
import com.github.moribund.images.DaggerSpriteComponent;
import com.github.moribund.images.SpriteComponent;
import com.github.moribund.images.SpriteFile;

public class GameScreen implements Screen {
    private final MoribundClient client;
    private final SpriteComponent spriteComponent = DaggerSpriteComponent.create();

    public GameScreen(MoribundClient client) {
        this.client = client;
    }

    @Override
    public void show() {
        drawGameFrame();
        drawPlayers();
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
            spriteComponent.getSpriteDrawer().drawSprite(SpriteFile.DUMMY_PLAYER, new Coordinate(50, 100), client.getSpriteBatch());
        });
    }

    private void clearGl() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void drawSpriteBatch(Runnable drawing) {
        client.getSpriteBatch().setProjectionMatrix(client.getCamera().combined);
        client.getSpriteBatch().begin();
        drawing.run();
        client.getSpriteBatch().end();
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

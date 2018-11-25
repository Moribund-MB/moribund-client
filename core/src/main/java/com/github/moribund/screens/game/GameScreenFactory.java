package com.github.moribund.screens.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.screens.ScreenFactory;
import lombok.val;

public class GameScreenFactory implements ScreenFactory {
    @Override
    public Screen createScreen() {
        val spriteBatch = createSpriteBatch();
        val camera = createCamera();
        return new GameScreen(spriteBatch, camera);
    }

    private SpriteBatch createSpriteBatch() {
        return new SpriteBatch();
    }

    private Camera createCamera() {
        val camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        return camera;
    }
}

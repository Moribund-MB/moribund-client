package com.github.moribund.screens.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.moribund.MoribundClient;
import com.github.moribund.images.SpriteContainer;
import com.github.moribund.objects.attributes.Drawable;
import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.playable.PlayableCharacter;
import com.github.moribund.utils.GLUtils;
import lombok.val;

/**
 * The {@code GameScreen} is the screen of the main game.
 */
class GameScreen implements Screen {

    /**
     * The sprite batch to display sprites.
     */
    private final SpriteBatch spriteBatch;
    /**
     * The camera to show the game on.
     */
    private final Camera camera;
    /**
     * The sprite that represents the background image.
     */
    private final Sprite background;

    /**
     * Constructor that provides the {@code GameScreen} its dependencies.
     * @param spriteBatch The sprite batch to display sprites.
     * @param camera The camera to show the game on.
     */
    GameScreen(SpriteBatch spriteBatch, Camera camera, Sprite background) {
        this.spriteBatch = spriteBatch;
        this.camera = camera;
        this.background = background;
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
        GLUtils.clearGL();
        drawSpriteBatch(this::drawBackground, this::drawVisibleEntities);
        cameraFollowPlayer();
    }

    private void drawBackground() {
        background.draw(spriteBatch);
    }

    private void cameraFollowPlayer() {
        val player = MoribundClient.getInstance().getPlayer();
        if (player != null) {
            camera.position.set(getCameraPositionX(player), getCameraPositionY(player), 0);
            camera.update();
        }
    }

    private float getCameraPositionX(PlayableCharacter player) {
        val playerX = player.getX();
        val balancingConstant = 400;
        val furthestLeftBound = -(background.getWidth() / 2) + balancingConstant;
        val furthestRightBound = background.getWidth() / 2 - balancingConstant;

        if (playerX >= furthestRightBound) {
            return furthestRightBound;
        } else if (playerX <= furthestLeftBound) {
            return furthestLeftBound;
        }
        return playerX;
    }

    private float getCameraPositionY(PlayableCharacter player) {
        val playerY = player.getY();
        val balancingConstant = 240;
        val furthestLowerBound = -(background.getHeight() / 2) + balancingConstant;
        val furthestUpperBound = background.getHeight() / 2 - balancingConstant;

        if (playerY >= furthestUpperBound) {
            return furthestUpperBound;
        } else if (playerY <= furthestLowerBound) {
            return furthestLowerBound;
        }
        return playerY;
    }

    /**
     * Draws all the {@link Drawable}'s
     * {@link com.badlogic.gdx.graphics.g2d.Sprite}s.
     */
    private void drawVisibleEntities() {
        MoribundClient.getInstance().getDrawables().forEach(drawable -> drawable.draw(spriteBatch));
    }

    /**
     * Processes all flaggables.
     */
    private void processFlags() {
        MoribundClient.getInstance().getFlaggables().forEach(Flaggable::processFlags);
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
    private void drawSpriteBatch(Runnable background, Runnable drawing) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.disableBlending();
        background.run();
        spriteBatch.enableBlending();
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
        spriteBatch.dispose();
    }
}
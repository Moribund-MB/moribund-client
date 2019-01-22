package com.github.moribund.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.github.moribund.MoribundClient;
import com.github.moribund.graphics.SpriteContainer;
import com.github.moribund.graphics.SpriteFile;
import com.github.moribund.graphics.drawables.DrawableGameAsset;
import com.github.moribund.objects.attributes.Collidable;
import com.github.moribund.objects.attributes.Flaggable;
import com.github.moribund.objects.playable.players.PlayableCharacter;
import com.github.moribund.objects.playable.players.containers.Inventory;
import com.github.moribund.utils.GLUtils;
import lombok.val;

/**
 * The {@code GameScreen} is the screen of the main game.
 */
class GameScreen implements Screen {

    private final SpriteBatch uiSpritebatch;
    /**
     * The sprite batch to display sprites.
     */
    private final SpriteBatch gameSpriteBatch;
    /**
     * The camera to show the game on.
     */
    private final Camera camera;
    /**
     * The sprite that represents the background image.
     */
    private final Sprite background;
    private final ShapeRenderer renderer;

    /**
     * Constructor that provides the {@code GameScreen} its dependencies.
     * @param uiSpritebatch The sprite batch to display the UI on.
     * @param gameSpritebatch The sprite batch to display the game sprites on.
     * @param camera The camera to show the game on.
     */
    GameScreen(SpriteBatch uiSpritebatch, SpriteBatch gameSpritebatch, Camera camera, Sprite background) {
        this.uiSpritebatch = uiSpritebatch;
        this.gameSpriteBatch = gameSpritebatch;
        this.camera = camera;
        this.background = background;
        renderer = new ShapeRenderer();
    }

    /**
     * The equivalent of {@link com.badlogic.gdx.Game#create()} where this
     * is run as soon as this screen is displayed.
     */
    @Override
    public void show() {
        renderer.setColor(Color.GREEN);
    }

    /**
     * Renders the {@link Screen} by clearing the GL and drawing the sprites.
     * Essentially, this is the heart of the game's {@link com.badlogic.gdx.graphics.g2d.Sprite}s.
     *
     * @param delta As of now, unclassified usage.
     */
    @Override
    public void render(float delta) {
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);
        processFlags();
        GLUtils.clearGL();
        drawGameSpriteBatch(this::drawBackground, this::drawVisibleEntities);
        drawUISpriteBatch(this::drawUI);
        cameraFollowPlayer();
        renderer.end();
    }

    private void drawUI() {
        val unselected = new Sprite[Inventory.SLOTS];
        val centeringConstant = 175; // todo find a more mathematical way to do this
        for (int i = 0; i < unselected.length; i++) {
            unselected[i] = new Sprite(SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_UNSELECTED));
            unselected[i].setX(Gdx.graphics.getWidth() - (unselected[i].getWidth() * (i + 1)) - centeringConstant);
            unselected[i].setY(0);
            unselected[i].setAlpha(0.8f);
            unselected[i].draw(uiSpritebatch);
        }
        val selected = new Sprite[2];
        for (int i = 0; i < selected.length; i++) {
            selected[i] = new Sprite(SpriteContainer.getInstance().getSprite(SpriteFile.INVENTORY_SELECTED));
            selected[i].setX(Gdx.graphics.getWidth() - (selected[i].getWidth() * (unselected.length + (i + 1))) - centeringConstant);
            selected[i].setY(0);
            selected[i].setAlpha(0.8f);
            selected[i].draw(uiSpritebatch);
        }
        MoribundClient.getInstance().getDrawableUIAssets().forEach(drawable -> drawable.draw(uiSpritebatch));
    }

    /**
     * Draws the {@link com.github.moribund.graphics.SpriteFile#BACKGROUND} {@link Sprite}.
     */
    private void drawBackground() {
        background.draw(gameSpriteBatch);
    }

    /**
     * Follows the player using the {@link GameScreen#getCameraPositionX(PlayableCharacter)} and
     * {@link GameScreen#getCameraPositionY(PlayableCharacter)} coordinates. The camera follows the player
     * until they are at an extreme coordinate in the map, to which the camera is static over that area.
     */
    private void cameraFollowPlayer() {
        val player = MoribundClient.getInstance().getPlayer();
        if (player != null) {
            camera.position.set(getCameraPositionX(player), getCameraPositionY(player), 0);
            camera.update();
        }
    }

    /**
     * Gets the optimal x-position for the camera given the {@link GameScreen#background} and {@link MoribundClient#player}.
     * @param player The {@link MoribundClient#player}.
     * @return The optimal x-position for the camera.
     */
    private float getCameraPositionX(PlayableCharacter player) {
        val playerX = player.getX();
        val balancingConstant = 500;
        val furthestLeftBound = -(background.getWidth() / 2) + balancingConstant;
        val furthestRightBound = background.getWidth() / 2 - balancingConstant;

        if (playerX >= furthestRightBound) {
            return furthestRightBound;
        } else if (playerX <= furthestLeftBound) {
            return furthestLeftBound;
        }
        return playerX;
    }

    /**
     * Gets the optimal y-position for the camera given the {@link GameScreen#background} and {@link MoribundClient#player}.
     * @param player The {@link MoribundClient#player}.
     * @return The optimal y-position for the camera.
     */
    private float getCameraPositionY(PlayableCharacter player) {
        val playerY = player.getY();
        val balancingConstant = 350;
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
     * Draws all the {@link DrawableGameAsset}'s
     * {@link com.badlogic.gdx.graphics.g2d.Sprite}s.
     */
    private void drawVisibleEntities() {
        MoribundClient.getInstance().getDrawableGameAssets().forEach(drawable -> {
            drawable.draw(gameSpriteBatch);
            if (drawable instanceof Collidable) {
                renderer.polygon(((Collidable) drawable).getPolygon().getTransformedVertices());
            }
        });
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
    private void drawGameSpriteBatch(Runnable background, Runnable drawing) {
        gameSpriteBatch.setProjectionMatrix(camera.combined);
        gameSpriteBatch.begin();
        gameSpriteBatch.disableBlending();
        background.run();
        gameSpriteBatch.enableBlending();
        drawing.run();
        gameSpriteBatch.end();
    }

    private void drawUISpriteBatch(Runnable drawing) {
        uiSpritebatch.begin();
        drawing.run();
        uiSpritebatch.end();
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
        gameSpriteBatch.dispose();
    }
}
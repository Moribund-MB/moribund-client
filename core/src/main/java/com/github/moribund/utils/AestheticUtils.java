package com.github.moribund.utils;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class AestheticUtils {
    private boolean cameraMovingLeft;

    public void renderAestheticSetting(Camera camera, Batch batch, Sprite background) {
        drawBackground(camera, batch, background);
        aestheticallyMoveCamera(camera);
    }

    private void drawBackground(Camera camera, Batch batch, Sprite background) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.disableBlending();
        background.draw(batch);
        batch.end();
    }

    private void aestheticallyMoveCamera(Camera camera) {
        val leftBound = 1550;
        val rightBound = 2450;
        val speed = 0.5;
        if (cameraMovingLeft) {
            camera.position.x -= speed;
            if (camera.position.x <= leftBound) {
                cameraMovingLeft = false;
            }
        } else {
            camera.position.x += speed;
            if (camera.position.x >= rightBound) {
                cameraMovingLeft = true;
            }
        }
        camera.update();
    }
}

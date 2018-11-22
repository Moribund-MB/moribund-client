package com.github.moribund.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.moribund.MoribundClient;
import lombok.val;

/** Launches the desktop (LWJGL) application. */
public class DesktopLauncher {
    public static void main(String[] args) {
        createApplication();
    }

    private static LwjglApplication createApplication() {
        return new LwjglApplication(new MoribundClient(), getDefaultConfiguration());
    }

    private static LwjglApplicationConfiguration getDefaultConfiguration() {
        val configuration = new LwjglApplicationConfiguration();

        configuration.title = "Moribund - 2D Battle Royale";
        configuration.width = DesktopDimension.WIDTH.getLength();
        configuration.height = DesktopDimension.HEIGHT.getLength();

        for (int size : new int[] { 128, 64, 32, 16 }) {
            configuration.addIcon("moribund" + size + ".png", FileType.Internal);
        }
        return configuration;
    }
}
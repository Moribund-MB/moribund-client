package com.github.moribund.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.moribund.MoribundClient;
import lombok.val;

/**
 * The {@code DesktopLauncher} class launches the desktop (LWJGL) application.
 */
public class DesktopLauncher {
    /**
     * The start point of the desktop client.
     * @param args The program arguments.
     */
    public static void main(String[] args) {
        createApplication();
    }

    /**
     * Creates an application by making a new {@link LwjglApplication} using
     * {@link MoribundClient}'s singleton instance and the {@link LwjglApplicationConfiguration}
     * provided by {@link DesktopLauncher#getDefaultConfiguration()}.
     * @return The created {@link LwjglApplication}.
     */
    private static LwjglApplication createApplication() {
        return new LwjglApplication(MoribundClient.getInstance(), getDefaultConfiguration());
    }

    /**
     * The configuration for the {@link LwjglApplication}.
     * @return The created configurations for the {@link LwjglApplication}.
     */
    private static LwjglApplicationConfiguration getDefaultConfiguration() {
        val configuration = new LwjglApplicationConfiguration();

        configuration.title = "Moribund - 2D Battle Royale";
        configuration.width = DesktopDimension.WIDTH.getLength();
        configuration.height = DesktopDimension.HEIGHT.getLength();

        for (int size : new int[] { 128, 64, 32, 16 }) {
            configuration.addIcon("images/moribund" + size + ".png", FileType.Internal);
        }
        return configuration;
    }
}
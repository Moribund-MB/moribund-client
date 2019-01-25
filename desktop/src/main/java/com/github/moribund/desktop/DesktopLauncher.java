package com.github.moribund.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.moribund.MoribundClient;
import com.github.moribund.ShutdownHook;
import lombok.val;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * The {@code DesktopLauncher} class launches the desktop (LWJGL) application.
 */
class DesktopLauncher {
    /**
     * The start point of the desktop client.
     * @param args The program arguments.
     */
    public static void main(String[] args) {
        setupShutdownHook();
        redirectExceptionsToFile();
        createApplication();
    }

    /**
     * Sets up a shutdown hook to be executed when the application is terminated.
     */
    private static void setupShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }

    /**
     * Redirects the stream of the {@link System#err} to a {@link FileOutputStream}.
     */
    private static void redirectExceptionsToFile() {
        try {
            PrintStream newOut = new PrintStream(new FileOutputStream("application_error.txt"));
            System.setErr(newOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        configuration.resizable = false;

        for (int size : new int[] { 128, 64, 32, 16 }) {
            configuration.addIcon("images/moribund" + size + ".png", FileType.Internal);
        }
        return configuration;
    }
}
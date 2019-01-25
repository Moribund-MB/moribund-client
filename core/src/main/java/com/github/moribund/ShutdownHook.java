package com.github.moribund;

import com.github.moribund.utils.EmailUtils;
import lombok.val;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * The shut down hook is called upon application failure to allow for the sending of an e-mail upon crashing.
 * A GUI was unable to be displayed as Java terminates it's GUI system when a system is shutting down.
 */
public class ShutdownHook extends Thread {
    @Override
    public void run() {
        StringBuilder exception = new StringBuilder();
        try {
            val fileScanner = new Scanner(new File("application_error.txt"));
            while (fileScanner.hasNextLine()) {
                exception.append(fileScanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(exception);
        if (!exception.toString().isEmpty()) {
            val scanner = new Scanner(System.in);
            System.out.println("The application has been terminated due to a runtime exception. Would you like to e-mail this? (Yes/No)");
            val response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                val localDateTime = LocalDateTime.now();
                EmailUtils.sendEmail("Moribund Email", EmailUtils.EMAIL, "Exception on "
                        + localDateTime.getMonthValue() + "/"
                        + localDateTime.getDayOfMonth() + "/"
                        + localDateTime.getYear(), exception.toString());
            }
            System.out.println();
            System.out.println("Thank you.");
        }
    }
}

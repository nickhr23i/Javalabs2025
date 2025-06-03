package org.example;

import java.io.IOException;
import java.util.logging.*;

public class ProjectLogger {
    private static Logger logger = null;

    private ProjectLogger() {
    }

    private static void setUpLogger() {
        logger = Logger.getLogger(ProjectLogger.class.getName());
        try {
            LogManager.getLogManager().reset(); // reset default settings

            ConsoleHandler ch = new ConsoleHandler();
            ch.setLevel(Level.INFO);
            ch.setFormatter(new SimpleFormatter());

            FileHandler fh = new FileHandler("lab9.log", true); // append mode
            fh.setLevel(Level.INFO);
            fh.setFormatter(new SimpleFormatter());

            logger.addHandler(ch);
            logger.addHandler(fh);

            logger.setLevel(Level.INFO);

        } catch (IOException e) {
            System.err.println("Failed to setup logger: " + e.getMessage());
        }
    }

    public static Logger getLogger() {
        if (logger == null) {
            setUpLogger();
        }
        return logger;
    }
}

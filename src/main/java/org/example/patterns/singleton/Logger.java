package org.example.patterns.singleton;

import java.time.LocalDateTime;

public class Logger {
    private static Logger logger; // единственный объект
    private int counter = 1;

    private Logger() {
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    protected void log(String msg) {
        System.out.println("[" + LocalDateTime.now() + " " + counter++ + "] " + msg);
    }
}

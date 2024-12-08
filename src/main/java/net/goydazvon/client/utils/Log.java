package net.goydazvon.client.utils;

import net.goydazvon.client.Main;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Log {

    private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    public static void log(String string) {
        FileHandler fh;

        try {
            fh = new FileHandler("latest.log");
            logger.addHandler(fh);

            SimpleFormatter formatter = new SimpleFormatter() {
                @Override
                public String format(java.util.logging.LogRecord record) {
                    return record.getMessage() + "\n";
                }
            };
            fh.setFormatter(formatter);

            logger.setUseParentHandlers(false);

            logger.info(string);

        } catch (SecurityException | IOException e) {
            new Error().println(e);
        }
    }
}

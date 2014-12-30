package com.lvy.log.logclient;

import ch.qos.logback.access.joran.JoranConfigurator;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.jar.JarException;

/**
 * Created by livvy on 14/11/6.
 */
public class MyApp3 {
    private static final Logger logger = LoggerFactory.getLogger(MyApp3.class);

    public static void main(String[] args) {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(lc);
            lc.reset();
            configurator.doConfigure("logback");
        } catch (JoranException e) {
            
        }

        StatusPrinter.printInCaseOfErrorsOrWarnings(lc);

        logger.info("Entering application");

        Foo foo = new Foo();

        foo.doIt();
        logger.info("Exiting application");

    }
}

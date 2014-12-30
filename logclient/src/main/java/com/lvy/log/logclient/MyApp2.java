package com.lvy.log.logclient;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by livvy on 14/11/5.
 */
public class MyApp2 {

    private static final Logger logger = LoggerFactory.getLogger(MyApp2.class);

    public static void main(String[] args) {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

        StatusPrinter.print(lc);

        logger.info("Entering application ");

        Foo foo = new Foo();
        foo.doIt();

        logger.info("Exiting application");


    }
}

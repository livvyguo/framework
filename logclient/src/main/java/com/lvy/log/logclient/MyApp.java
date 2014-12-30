package com.lvy.log.logclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by livvy on 14/11/5.
 */
public class MyApp {

    private static final Logger logger = LoggerFactory.getLogger(MyApp.class);

    public static void main(String[] args) {
        logger.info("Entering application.");
        Foo foo = new Foo();
        foo.doIt();
        logger.info("Exiting application.");

    }
}

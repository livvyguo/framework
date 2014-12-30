package com.lvy.log.logclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by livvy on 14/11/5.
 */
public class Foo {
    private static final Logger logger = LoggerFactory.getLogger(Foo.class);

    public void doIt() {

        logger.debug("Did it again!");

    }
}

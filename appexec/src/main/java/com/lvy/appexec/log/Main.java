package com.lvy.appexec.log;

import com.lvy.appexec.util.log.LogFactory;
import org.slf4j.Logger;

/**
 * Created by livvy on 14/11/3.
 */
public class Main {

    private static final Logger logger = LogFactory.getLogger();

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            logger.error("hrello");
        }
        logger.error("test", "sss");
    }
}

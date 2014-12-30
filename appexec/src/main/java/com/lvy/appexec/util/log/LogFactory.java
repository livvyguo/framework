package com.lvy.appexec.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by livvy on 14-9-2.
 */
public final class LogFactory {
    private LogFactory() {
        throw new AssertionError("no instance for you!");
    }


    public static final Logger getLogger() {
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        String className = stackTrace[1].getClassName();
        return LoggerFactory.getLogger(className);
    }
}

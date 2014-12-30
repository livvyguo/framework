package com.lvy.framework.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2014/12/2.
 */
public final class Loggers {
    private Loggers() {
        throw new AssertionError("no instance for you");
    }

    public static Logger getLogger() {
        Throwable throwable = new Throwable();
        StackTraceElement stackTraceElement = throwable.getStackTrace()[1];
        return LoggerFactory.getLogger(stackTraceElement.getClassName());
    }
}

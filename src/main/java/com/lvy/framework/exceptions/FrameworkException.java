package com.lvy.framework.exceptions;

/**
 * Created by livvy on 14-4-30.
 */
public class FrameworkException extends Exception {

    static final long serialVersionUID = -7034897190745766939L;

    public FrameworkException() {
        super();
    }

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }


    public FrameworkException(Throwable cause) {
        super(cause);
    }


    protected FrameworkException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

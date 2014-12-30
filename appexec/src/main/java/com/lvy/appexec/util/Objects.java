package com.lvy.appexec.util;

/**
 * Created by livvy on 14-9-2.
 */
public class Objects {
    private Objects() {
        throw new AssertionError();
    }

    public static <T> T requireNonNull(T object) {
        if (object == null) {
            throw new NullPointerException();
        }
        return object;
    }

    public static <T> T requireNonNull(T object,String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }


}

package com.lvy.appexec.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by livvy on 14-8-22.
 */
public final class IOUtils {
    private IOUtils() {
        throw new AssertionError();
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }

}

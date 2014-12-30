package com.lvy.appexec;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by livvy on 14/12/12.
 */
public class IDGenerator {
    private IDGenerator() {
        throw new AssertionError("no instance for you!");
    }

    private AtomicReference times = new AtomicReference();

//    private AtomicStampedReference t = new AtomicStampedReference();
    public static void main(String[] args) {

    }
}

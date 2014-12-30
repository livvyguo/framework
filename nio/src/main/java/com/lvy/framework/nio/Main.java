package com.lvy.framework.nio;

import java.nio.CharBuffer;

/**
 * Created by livvy on 14-9-18.
 */
public class Main {

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(100);
        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }

    }

    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println("");
    }

    private static boolean fillBuffer(CharBuffer buffer) {
        if (index > strings.length) {
            return false;
        }
        String string = strings[index++];

        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        return true;
    }


    private static int index = 0;

    private static String[] strings = {
            "A random string value",
            "The produce of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees : Jimi Hendrix",
            "'Cause me while I kiss this fly",
            "Help Me! Help Me!"
    };

}

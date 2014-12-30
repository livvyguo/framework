package com.lvy.appexec.util.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by livvy on 14-8-25.
 */
public class Maps {
    /***
     * no instance for anyone
     */
    private Maps() {
        throw new AssertionError("no instance for you!");
    }

    public static <K,V> HashMap<K,V> newHashMap() {
        return new HashMap<K,V>();
    }

    public static <K,V> LinkedHashMap<K,V> newLinkedHashMap() {
        return new LinkedHashMap<K,V>();
    }

    public static <K,V> LinkedHashMap<K,V> newLinkedHashMap(int initialCapacity) {
        return new LinkedHashMap<K, V>(initialCapacity);
    }
}

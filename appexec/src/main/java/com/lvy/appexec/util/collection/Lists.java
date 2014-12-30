package com.lvy.appexec.util.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by livvy on 14-8-25.
 */
public final class Lists {

    private Lists() {
        throw new AssertionError("no instance for you!");
    }

    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<E>();
    }



}

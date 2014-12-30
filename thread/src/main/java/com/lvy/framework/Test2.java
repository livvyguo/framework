package com.lvy.framework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by livvy on 14-5-27.
 */
public class Test2 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("((高)|(二中))");
        Matcher matcher = pattern.matcher("中");
        boolean matches = matcher.matches();
        System.out.println(matches);


    }
}

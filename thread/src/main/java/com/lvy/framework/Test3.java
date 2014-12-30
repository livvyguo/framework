package com.lvy.framework;

import java.io.File;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by livvy on 14-6-28.
 */
public class Test3 {
    public static void main(String[] args) {

        String separator = File.separator;
        System.out.println(separator);

        String s = "D:" + separator + "aa.txt";
        System.out.println(s);

        Properties properties = System.getProperties();
        Set<Map.Entry<Object,Object>> entries = properties.entrySet();
        entries.forEach(e->{
            System.out.println(e.getKey());});
        String property = System.getProperty("file.separator");
        System.out.println(property);

    }
}

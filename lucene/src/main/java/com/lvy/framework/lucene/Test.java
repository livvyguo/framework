package com.lvy.framework.lucene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;

/**
 * Created by livvy on 14-6-17.
 */
public class Test {

    public static class Main{
        public static void main(String[] args) throws IOException  {
            Instant now = Instant.now();


            while (true) {
                URL url = new URL("");
                URLConnection connection = url.openConnection();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line = null;
//                    while ((line = br.readLine()) != null) {
//                       // System.out.println(line);
//                    }
                    System.out.println("sss");
                }

            }


        }

    }
}

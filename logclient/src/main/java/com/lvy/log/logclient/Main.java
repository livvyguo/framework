package com.lvy.log.logclient;

import com.mongodb.*;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by livvy on 14/11/4.
 */
public class Main {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws UnknownHostException {
        MongoCredential credential = MongoCredential.createMongoCRCredential("sa", "admin", "sa".toCharArray());
        MongoClient client = new MongoClient(new ServerAddress("192.168.36.190",27107), Arrays.asList(credential));
        DB mydb = client.getDB("mydb");
        Set<String> collectionNames = mydb.getCollectionNames();

        for(String s  : collectionNames) {
            System.out.println(s);
        }


    }
}

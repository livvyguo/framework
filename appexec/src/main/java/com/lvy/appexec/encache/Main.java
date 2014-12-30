package com.lvy.appexec.encache;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by livvy on 14-9-10.
 */
public class Main {
    public static void main(String[] args) {
        CacheManager cacheManager = CacheManager.create();
        Cache cache = new Cache("test", 1, true, false, 5, 2);
        cacheManager.addCache(cache);
        Cache test = cacheManager.getCache("test");
        System.out.println(test == cache);
        Element element = new Element("key1", "value");
        cache.put(element);
        Element element1 = cache.get("key1");
        System.out.println(element1.getObjectValue());
        cacheManager.shutdown();
    }
}

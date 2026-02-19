package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CacheInspectionService { // purpose of this class:  to see how cache storing data


    @Autowired
    private CacheManager cacheManager;


    public void printCacheContents(String cacheName){
        Cache cache = cacheManager.getCache(cacheName);
       if (cache !=null){
           System.out.println("cache contents: ");
           System.out.println(Objects.requireNonNull(cache.getNativeCache()).toString());
       }else {
           System.out.println("no such cache: "+cacheName);
       }
    }
}

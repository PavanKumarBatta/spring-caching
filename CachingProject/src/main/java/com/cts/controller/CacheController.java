package com.cts.controller;


import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CacheController {

	private final CacheManager cacheManager;
	
	@GetMapping("/cache")
	public ConcurrentHashMap<Object, Object> getCache() {
		
		Cache cache = cacheManager.getCache("weather");
		
		log.info(cache+"");
        ConcurrentMapCache mapCache = (ConcurrentMapCache) cache;
        ConcurrentHashMap<Object, Object> store =
                (ConcurrentHashMap<Object, Object>) mapCache.getNativeCache();

        return store; 
	}
}

package com.cts.controller;


import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CacheController {

	
	private final RedisTemplate<String, Object> redisTemplate;
	private final CacheManager cacheManager;

	@GetMapping("/redis-keys")
	public Object getAllKeys() {
	    return redisTemplate.keys("*");
	}

	

	@PostConstruct
	public void test() {
	    System.out.println("CACHE MANAGER = " + cacheManager.getClass().getName());
	}

}

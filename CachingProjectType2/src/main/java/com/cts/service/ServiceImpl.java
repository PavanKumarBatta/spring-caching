package com.cts.service;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cts.model.Climate;
import com.cts.repository.Repositoryy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements Services {
	
	private final Repositoryy repo;

	@Override
	public String add(Climate climate) {
		
		repo.save(climate);
		return "Saved Successfully";
	}

	@Override
	@Cacheable(value="weather")
	public Climate getClimate(int id) {
		Optional<Climate>op=repo.findById(id);
		return op.get();
	}

	@Override
	@CachePut(value = "weather", key = "#id")
	public Climate updateClimate(int id, int temp) {
	    Climate c = repo.findById(id).orElseThrow();
	    c.setTemparature(temp);
	    return repo.save(c);
	}

	@Override
	@CacheEvict(value="weather",key="#id")
	public String deleteClimate(int id) {
		
		repo.deleteById(id);
		return "deleted successfully";
	}
}
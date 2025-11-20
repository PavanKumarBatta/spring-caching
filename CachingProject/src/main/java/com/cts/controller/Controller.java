package com.cts.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Climate;
import com.cts.service.Services;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controller {
	
	private final Services service;

	@PostMapping("/add")
	public String addClimate(@RequestBody Climate climate) {
		
		return service.add(climate);
	}
	
	@GetMapping("/getById/{id}")
	public Climate getClimate(@PathVariable int id) {
		
		return service.getClimate(id);
	}
	
	@PutMapping("/update/{id}/{temp}")
	public Climate updateClimate(@PathVariable int id,@PathVariable int temp) {
		
		
		return service.updateClimate(id,temp);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteClimate(@PathVariable int id) {
		
		
		return service.deleteClimate(id);
	}
}

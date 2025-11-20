package com.cts.service;


import com.cts.model.Climate;

public interface Services {

	String add(Climate climate);

	Climate getClimate(int id);

	Climate updateClimate(int id, int temp);

	String deleteClimate(int id);

}

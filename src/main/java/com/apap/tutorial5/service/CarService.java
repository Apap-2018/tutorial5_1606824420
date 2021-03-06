package com.apap.tutorial5.service;

import java.util.List;

import com.apap.tutorial5.model.CarModel;

/**
 * CarService
 */
public interface CarService {
	void addCar(CarModel car);
	public void deleteById(Long id);
	CarModel getCar(Long id);
	void updateCar(long id,CarModel car);
	void deleteById(CarModel car);
}

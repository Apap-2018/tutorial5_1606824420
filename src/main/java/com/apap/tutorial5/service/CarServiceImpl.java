package com.apap.tutorial5.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.repository.CarDb;

/**
 * CarServiceImpl
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDb carDb;
	
	@Override
	public void addCar(CarModel car) {
		carDb.save(car);
	}
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		carDb.deleteById(id);
	}
	public CarModel getCar(Long id) {
		return carDb.findById(id).get();
	}
	@Override
	public void updateCar(long id, CarModel newCar) {
		CarModel temp = carDb.getOne(id);
		temp.setBrand(newCar.getBrand());
		temp.setType(newCar.getType());
		temp.setPrice(newCar.getPrice());
		temp.setAmount(newCar.getAmount());
		carDb.save(temp);
	}
	@Override
	public void deleteById(CarModel car) {
		// TODO Auto-generated method stub
		carDb.delete(car);
	}
}

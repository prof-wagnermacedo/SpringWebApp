package com.wagnermacedo.service;

import com.wagnermacedo.domain.Car;
import com.wagnermacedo.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarDAO carDAO;

    public void add(Car car) {
        carDAO.add(car);
    }

    public List<Car> findAll() {
        return carDAO.findAll();
    }

    public Car find(long id) {
        return carDAO.findById(id);
    }
}

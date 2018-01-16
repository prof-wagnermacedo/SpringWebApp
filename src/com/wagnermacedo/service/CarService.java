package com.wagnermacedo.service;

import com.wagnermacedo.domain.Car;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CarService {
    private List<Car> carList = new LinkedList<>();

    CarService() {
        Car car1 = new Car();
        car1.setName("Mercedes SL");
        car1.setPrice(123400);
        carList.add(car1);

        Car car2 = new Car();
        car2.setName("BMW M6 Coupé");
        car2.setPrice(125000);
        carList.add(car2);

        Car car3 = new Car();
        car3.setName("Audi R8");
        car3.setPrice(136100);
        carList.add(car3);
    }

    public List<Car> findAll() {
        return carList;
    }
}

package com.wagnermacedo.service;

import com.wagnermacedo.domain.Car;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
public class CarService {
    private List<Car> carList = new LinkedList<>();

    CarService() {
        Car car1 = new Car();
        car1.setName("Mercedes SL");
        car1.setPrice(new BigDecimal(123400));
        this.add(car1);

        Car car2 = new Car();
        car2.setName("BMW M6 Coupé");
        car2.setPrice(new BigDecimal(125000));
        this.add(car2);

        Car car3 = new Car();
        car3.setName("Audi R8");
        car3.setPrice(new BigDecimal(136100));
        this.add(car3);
    }

    private static long sequencia = 0;

    public void add(Car car) {
        car.setId(++sequencia);
        carList.add(car);
    }

    public List<Car> findAll() {
        return carList;
    }

    public Car find(long id) {
        for (Car car : carList) {
            if (id == car.getId()) {
                return car;
            }
        }

        throw new IllegalArgumentException("id=" + id);
    }
}

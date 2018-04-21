package primavera.dao;

import org.springframework.stereotype.Service;
import primavera.domain.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarDao {
    private final List<Car> carList = new ArrayList<>();
    private static long sequence = 0;

    CarDao() {
        Car car1 = new Car();
        car1.setName("Mercedes SL");
        car1.setPrice(BigDecimal.valueOf(123400));
        this.add(car1);

        Car car2 = new Car();
        car2.setName("BMW M6 Coupé");
        car2.setPrice(BigDecimal.valueOf(125000));
        this.add(car2);

        Car car3 = new Car();
        car3.setName("Audi R8");
        car3.setPrice(BigDecimal.valueOf(136100));
        this.add(car3);
    }

    public void add(Car car) {
        sequence += 1;
        car.setId(sequence);
        carList.add(car);
    }

    public List<Car> findAll() {
        return carList;
    }

}

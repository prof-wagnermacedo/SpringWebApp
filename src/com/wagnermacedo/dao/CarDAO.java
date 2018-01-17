package com.wagnermacedo.dao;

import com.wagnermacedo.domain.Accessory;
import com.wagnermacedo.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class CarDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Car car) {
        String sql = "INSERT INTO Car (name, price) VALUES (?, ?)";
        jdbcTemplate.update(sql, car.getName(), car.getPrice());
    }

    public void add(List<Car> carList) {
        String sql = "INSERT INTO Car (name, price) VALUES (?, ?)";

        List<Object[]> carRows = new ArrayList<>();
        for (Car car : carList) {
            carRows.add(new Object[] {car.getName(), car.getPrice()});
        }

        jdbcTemplate.batchUpdate(sql, carRows);
    }

    public void update(Car car) {
        String sql = "UPDATE Car SET name=?, price=? WHERE id=?";
        jdbcTemplate.update(sql, car.getName(), car.getPrice(), car.getId());
    }

    public void save(Car car) {
        if (car.getId() == null) {
            add(car);
        }
        else {
            update(car);
        }
    }

    public void delete(Car user) {
        String sql = "DELETE FROM Car WHERE id=?";
        jdbcTemplate.update(sql, user.getId());
    }

    public long countCheapCars() {
        String sql = "SELECT count(*) FROM Car WHERE price < 5000";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    public List<Car> findAll() {
        String sql =
                "SELECT c.id, c.name, c.price, a.id as a_id, a.description FROM Car c " +
                "LEFT JOIN Accessory a ON a.car_id = c.id " +
                "ORDER BY c.id ASC";
        List<Car> carList = jdbcTemplate.query(sql, new CarWithAccessories());
        return carList;
    }

    public Car findById(long id) {
        String sql = "SELECT * FROM Car WHERE id=?";
        Car car = jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(Car.class));
        return car;
    }

    private class CarWithAccessories implements ResultSetExtractor<List<Car>> {
        @Override
        public List<Car> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, Car> carMap = new Hashtable<>();
            Car c = null;
            while (rs.next()) {
                // carro está no map?
                long id = rs.getLong("id");
                c = carMap.get(id);

                // se não, adiciona
                if (c == null) {
                    c = new Car();
                    c.setId(id);
                    c.setName(rs.getString("name"));
                    c.setPrice(rs.getBigDecimal("price"));
                    carMap.put(id, c);
                }

                // cria acessório, se existir
                long accessoryId = rs.getLong("a_id");
                if (accessoryId > 0) {
                    Accessory a = new Accessory();
                    a.setId(accessoryId);
                    a.setDescription(rs.getString("description"));
                    c.getAccessories().add(a);
                }
            }

            LinkedList<Car> cars = new LinkedList<>(carMap.values());
            return cars;
        }
    }
}

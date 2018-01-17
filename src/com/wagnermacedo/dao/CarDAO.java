package com.wagnermacedo.dao;

import com.wagnermacedo.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Car car) {
        String sql = "INSERT INTO Car (name, price) VALUES (?, ?)";
        jdbcTemplate.update(sql, car.getName(), car.getPrice());
    }

    public List<Car> findAll() {
        String sql = "SELECT * FROM Car";
        List<Car> carList = jdbcTemplate.query(sql, new CarMapper());
        return carList;
    }

    public Car findById(long id) {
        String sql = "SELECT * FROM Car WHERE id=?";
        Car car = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CarMapper());
        return car;
    }

    private class CarMapper implements RowMapper<Car> {
        public Car mapRow(ResultSet row, int rowNum) throws SQLException {
            Car car = new Car();

            car.setId(row.getLong("id"));
            car.setName(row.getString("name"));
            car.setPrice(row.getBigDecimal("price"));

            return car;
        }
    }
}

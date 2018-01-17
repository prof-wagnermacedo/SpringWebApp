package com.wagnermacedo.dao;

import com.wagnermacedo.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Car car) {
        String sql = "INSERT INTO Car (name, price) VALUES (?, ?)";
        jdbcTemplate.update(sql, car.getName(), car.getPrice());
    }
}

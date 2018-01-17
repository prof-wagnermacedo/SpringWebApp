package com.wagnermacedo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
}

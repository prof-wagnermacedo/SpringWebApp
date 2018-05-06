package primavera.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import primavera.domain.Car;

import java.util.List;

@Repository
public class CarDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<Car> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Car.class);

    public void add(Car car) {
        throw new UnsupportedOperationException();
    }

    public Car get(long id) {
        throw new UnsupportedOperationException();
    }

    public void edit(Car car) {
        throw new UnsupportedOperationException();
    }

    public void delete(long id) {
        throw new UnsupportedOperationException();
    }

    public List<Car> findAll() {
        String sql = "SELECT * FROM Cars";
        List<Car> cars = jdbcTemplate.query(sql, ROW_MAPPER);

        return cars;
    }

}

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
        String sql = "INSERT INTO Cars (name, price, color) values (?, ?, ?);";
        jdbcTemplate.update(sql, car.getName(), car.getPrice(), car.getColor());
    }

    public Car get(long id) {
        String sql = "SELECT * FROM Cars WHERE id=?";
        Car car = jdbcTemplate.queryForObject(sql, ROW_MAPPER, id);

        return car;
    }

    public void edit(Car car) {
        String sql = "UPDATE Cars SET name=?, price=?, color=? WHERE id=?";
        int rows = jdbcTemplate.update(sql, car.getName(), car.getPrice(), car.getColor(), car.getId());

        if (rows == 0) {
            throw new IllegalArgumentException("Carro não encontrado: " + car.getId());
        }
    }

    public void delete(long id) {
        String sql = "DELETE FROM Cars WHERE id=?";
        int rows = jdbcTemplate.update(sql, id);

        if (rows == 0) {
            throw new IllegalArgumentException("Carro não encontrado: " + id);
        }
    }

    public List<Car> findAll() {
        String sql = "SELECT * FROM Cars";
        List<Car> cars = jdbcTemplate.query(sql, ROW_MAPPER);

        return cars;
    }

}

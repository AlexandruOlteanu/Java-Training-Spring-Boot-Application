package db.javaschool.session_11.application.repositories;


import db.javaschool.session_11.application.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Order> getAllOrders() {
        String statement = "SELECT * FROM orders";
        return jdbcTemplate.query(statement, new OrderRowMapper());
    }

    public Order getOrderByID(long id) {
        String statement = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(statement, new OrderRowMapper(), id);
    }

    public void insertOrder(Order order) {
        String statement = "INSERT INTO orders (order_date, shipped_date, status, comments, customer_id)" +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(statement, order.getOrderDate(), order.getShippedDate(), order.getStatus(), order.getComments(), order.getCustomerId());
    }
}


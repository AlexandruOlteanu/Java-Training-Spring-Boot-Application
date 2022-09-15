package db.javaschool.session_11.application.repositories;

import db.javaschool.session_11.application.entities.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order(
                rs.getDate("order_date"),
                rs.getDate("shipped_date"),
                rs.getString("status"),
                rs.getString("comments"),
                rs.getLong("customer_id")
        );
        return order;
    }
}

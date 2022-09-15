package db.javaschool.session_11.application.repositories;

import db.javaschool.session_11.application.entities.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer(
                rs.getString("username"),
                rs.getString("last_name"),
                rs.getString("first_name"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("postalCode"),
                rs.getString("country"));
        return customer;
    }
}
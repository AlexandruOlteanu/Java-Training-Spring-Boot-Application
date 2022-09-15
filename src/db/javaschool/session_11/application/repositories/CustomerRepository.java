package db.javaschool.session_11.application.repositories;

import db.javaschool.session_11.application.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository // VIEW
public class CustomerRepository {
        JdbcTemplate jdbcTemplate;

        @Autowired
        public CustomerRepository(DataSource dataSource) {
                this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

        public List<Customer> getAllCustomers() {
                String statement = "SELECT * FROM customers";
                return jdbcTemplate.query(statement, new CustomerRowMapper());
        }

        public Customer getCustomerById(long id) {
                String statement = "SELECT * FROM customers WHERE id=?";
                return jdbcTemplate.queryForObject(statement, new CustomerRowMapper(), id);
        }

        public void insertCustomer(Customer customer){
                String statement = "INSERT INTO customers (username, last_name, first_name, phone, address, city, postalCode, country) " +
                        "VALUES (?,?,?,?,?,?,?,?)";
                jdbcTemplate.update(statement, customer.getUsername(), customer.getLastName(), customer.getFirstName(), customer.getPhone(),
                        customer.getAddress(), customer.getCity(), customer.getPostalCode(), customer.getCountry());
        }

        public void updateCustomer(Customer customer, long id){
                String statement = "UPDATE customers SET username = ?, last_name = ?, first_name = ?, phone = ?, address = ?, city = ?, postalCode = ?, country = ? WHERE id = ?";
                jdbcTemplate.update(statement, customer.getUsername(), customer.getLastName(), customer.getFirstName(), customer.getPhone(),
                        customer.getAddress(), customer.getCity(), customer.getPostalCode(), customer.getCountry(), id);
        }

        public void deleteCustomer(long id) {
                String statement = "DELETE FROM customers WHERE id=?";
                jdbcTemplate.update(statement, id);
        }
}

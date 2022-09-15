package db.javaschool.session_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseManager {
    public Connection connection;

    public DatabaseManager() throws FileNotFoundException {
        File f = new File("credentials.txt");
        if (!f.exists()) {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(f);
        String databaseName = scanner.nextLine();
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        scanner.close();

        String connectionUrl = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Customer getCustomerbyId(int id) {
        Customer customer = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Customer WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("postalCode"),
                        resultSet.getString("country")

                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    public List<Customer> getAllCustomers() {
        Customer customer = null;
        List<Customer> customerList = new ArrayList<>();
        try {
            Statement ps = connection.createStatement();
            ResultSet resultSet = ps.executeQuery("SELECT * FROM Customer");

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("last_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("postalCode"),
                        resultSet.getString("country"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    public void updateCustomer(Customer customer) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE Customer SET " +
                            "username = ?," +
                            "last_name = ?," +
                            "first_name = ?," +
                            "phone = ?," +
                            "address = ?," +
                            "city = ?," +
                            "postalCode = ?," +
                            "country = ? " +
                            "WHERE id = ?"
            );
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getFirstName());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getCity());
            ps.setString(7, customer.getPostalCode());
            ps.setString(8, customer.getCountry());
            ps.setInt(9, customer.getId());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertCustomer(Customer customer) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO customers(username, last_name, first_name, phone, address, city, postalCode, country) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?) "
            );

            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getFirstName());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getCity());
            ps.setString(7, customer.getPostalCode());
            ps.setString(8, customer.getCountry());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertOrder(Order order) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO orders(order_date, shipped_date, status, comments, customer_id) " +
                            "VALUES (?, ?, ?, ?, ?) "
            );

            ps.setDate(1, order.getOrderDate());
            ps.setDate(2, order.getShippedDate());
            ps.setString(3, order.getStatus());
            ps.setString(4, order.getComments());
            ps.setInt(5, order.getCustomerId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCustomer(String username) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM customers WHERE username =?");
            ps.setString(1, username);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCustomerById(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM customers WHERE id =?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Order getOrderById(int id) {
        Order order = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ORDERS WHERE id=?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                order = new Order(
                        resultSet.getInt("id"),
                        resultSet.getDate("order_date"),
                        resultSet.getDate("shipped_date"),
                        resultSet.getString("status"),
                        resultSet.getString("comments"),
                        getCustomerbyId(resultSet.getInt("customer_id"))

                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return order;
    }

    public void createOrder(Order order) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO orders(order_date, shipped_date,status,comments,customer_id) " +
                            " VALUES(?,?,?,?,?)");
            ps.setDate(1, order.getOrderDate());
            ps.setDate(2, order.getShippedDate());
            ps.setString(3, order.getStatus());
            ps.setString(4, order.getComments());
            ps.setInt(5, order.getCustomer().getId());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Order> getOrdersForCustomer(Customer customer) {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ORDERS WHERE customer_id=?");
            ps.setInt(1, customer.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                orders.add(
                        new Order(
                                resultSet.getInt("id"),
                                resultSet.getDate("order_date"),
                                resultSet.getDate("shipped_date"),
                                resultSet.getString("status"),
                                resultSet.getString("comments"),
                                customer
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }
}

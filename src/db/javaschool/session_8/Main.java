package db.javaschool.session_8;

import db.javaschool.session_9.Problems.ActiveRecord;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;

public class Main {

    public static void insertIntoCustomers(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO `Customer` VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);"
        );
        ps.setInt(1, 4);
        ps.setString(2, "username4");
        ps.setString(3, "Gigel");
        ps.setString(4, "Gigelica");
        ps.setString(5, "07gigel");
        ps.setString(6, "Strada lui gigel");
        ps.setString(7, "Bucuresti");
        ps.setString(8, "010203");
        ps.setString(9, "Romania");
        ps.execute();
    }

    public static void main(String[] args) {
        DatabaseManager databaseManager = null;
        try {
            databaseManager = new DatabaseManager();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Customer customer = databaseManager.getCustomerbyId(2);
        System.out.println(customer);

        customer.setLastName("Vovo");
        databaseManager.updateCustomer(customer);

        customer.setLastName("Sebastian");
        customer.setUsername("seb_user");
        customer.setCity("Ploiesti");
        databaseManager.insertCustomer(customer);

         databaseManager.deleteCustomer(customer.getUsername());
        
        List<Customer> customerList = databaseManager.getAllCustomers();
        for(Customer customer1 : customerList) {
            System.out.println(customer1);
        }

        Customer new_customer = customerList.get(0);

        Order order = new Order(
                5,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()),
                "shipping",
                "to be delivered",
                new_customer
            );

        databaseManager.createOrder(order);
        databaseManager.createOrder(order);

        List<Order> orders = databaseManager.getOrdersForCustomer(new_customer);
        for(Order _order : orders) {
            System.out.println(_order);
        }
        ActiveRecord activeRecord = new ActiveRecord(databaseManager);
        new_customer.setAddress("Calea Berceni");
        activeRecord.update(new_customer);

        order.setStatus("Delivered");
        activeRecord.update(order);

    }
}

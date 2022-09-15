package db.javaschool.session_8;

import db.javaschool.session_9.Problems.ActiveRecordEntity;
import db.javaschool.session_9.Problems.Column;

import java.util.HashMap;

@ActiveRecordEntity(tableName = "customers", primaryKey = "id")
public class Customer extends DatabaseObject {
    @Column("id")
    private int id;

    @Column("username")
    private String username;

    @Column("last_name")
    private String lastName;
    @Column("first_name")
    private String firstName;
    @Column("phone")
    private String phone;
    @Column("address")
    private String address;
    @Column("city")
    private String city;
    @Column("postalCode")
    private String postalCode;
    @Column("country")
    private String country;


    public Customer(int id, String username, String lastName, String firstName, String phone, String address, String city, String postalCode, String country) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Customer(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

package db.javaschool.session_11.application.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    Customer customer;
    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User(long id, String username, String password, Customer customer) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.customer = customer;
    }

    }

package db.javaschool.session_11.application.entities;

import javax.persistence.*;
import java.sql.Date;

//@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Date orderDate;
    @Column(nullable = true)
    private Date shippedDate;
    @Column(nullable = false)
    private String status;
    @Column(nullable = true)
    private String comments;
    @Column(nullable = true)
    private long customerId;

    public Order() {
    }

    public Order(Date orderDate, Date shippedDate, String status, String comments, long customerId) {
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }


}

package db.javaschool.session_8;

import db.javaschool.session_9.Problems.ActiveRecordEntity;
import db.javaschool.session_9.Problems.Column;

import java.sql.Date;
@ActiveRecordEntity(tableName = "orders", primaryKey = "id")
public class Order extends DatabaseObject {
    @Column("id")
    private int id;
    @Column("order_date")
    private Date orderDate;
    @Column("shipped_date")
    private Date shippedDate;
    @Column("status")
    private String status;
    @Column("comments")
    private String comments;
    private Customer customer;
    @Column("customer_id")
    private int customerId;

    public Order() {
    }

    public Order(int id, Date orderDate, Date shippedDate, String status, String comments, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customer = customer;
        this.customerId = customer.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Customer getCustomer() {
        return customer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", shippedDate=" + shippedDate +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", customer=" + customer +
                '}';
    }
}

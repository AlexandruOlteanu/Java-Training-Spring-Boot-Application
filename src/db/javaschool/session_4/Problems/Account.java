package db.javaschool.session_4.Problems;

import java.util.Date;

public class Account {
    private int id;
    private String iban;
    private Currency currency;
    private double amount;
    private Date created_date;
    private  double interest;

    Account(int id, String iban, Currency currency, double amount, Date created_date, double interest) {
        this.id = id;
        this.iban = iban;
        this.currency = currency;
        this.amount = amount;
        this.created_date = created_date;
        this.interest = interest;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if(amount<0 ){
            throw new UnsupportedOperationException("Value is below zero.");
        }
        this.amount = amount;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }


}

package com.company;
import java.util.Date;

public abstract class Insurance {
    private String name;
    private int price;
    private Date startingDate;
    private Date expirationDate;

    public Insurance() {
        this.name = this.getClass().getName();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    public abstract void calculate(Accoount accoount);
}

package com.example.models;

import java.io.Serializable;

public class OrderDish implements Serializable {

    private String name;
    private int price,amount;

    public OrderDish(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public OrderDish() {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

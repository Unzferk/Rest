package com.example.models;

import java.io.Serializable;
import java.util.List;

public class OrderList implements Serializable {

    private String id;
    private int nroTable;
    private List<OrderDish> orders;
    private boolean done;

    public OrderList(String id, int nroTable, List<OrderDish> orders) {
        this.id = id;
        this.nroTable = nroTable;
        this.orders = orders;
        this.done = false;
    }

    public OrderList() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNroTable() {
        return nroTable;
    }

    public void setNroTable(int nroTable) {
        this.nroTable = nroTable;
    }

    public List<OrderDish> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDish> orders) {
        this.orders = orders;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getTotal(){
        int total=0;
        if(!orders.isEmpty()){
            for (OrderDish o:orders){
                int aux=o.getAmount()*o.getPrice();
                total=total+aux;
            }
        }
        return total;
    }
}

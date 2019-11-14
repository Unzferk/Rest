package com.example.models;

import java.io.Serializable;
import java.util.List;

public class OrderM implements Serializable {

    private int nroTable;
    private List<OrderDish> orders;

    public OrderM(int nroTable, List<OrderDish> orders) {
        this.nroTable = nroTable;
        this.orders = orders;
    }

    public OrderM() {
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

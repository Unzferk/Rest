package com.example.rest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.models.OrderM;

public class KitchenOrderDetail extends AppCompatActivity {


    RecyclerView rv_orderDetails;
    AdapterKitchOrdDetails adapter;
    OrderM ordM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_order_detail);

        Intent i=getIntent();
        ordM=(OrderM) i.getSerializableExtra("obj");

        rv_orderDetails=findViewById(R.id.rv_kit_ord_cont);
        rv_orderDetails.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL ));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_orderDetails.setLayoutManager(linearLayoutManager);


        adapter=new AdapterKitchOrdDetails(ordM.getOrders());
        rv_orderDetails.setAdapter(adapter);
    }


}

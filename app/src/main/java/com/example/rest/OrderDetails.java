package com.example.rest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.models.OrderM;

public class OrderDetails extends AppCompatActivity {

    //Attributes
    TextView nroTable,total;
    RecyclerView rv_orderDetails;
    AdapterOrderDetails adapter;

    OrderM ordM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);


        Intent i=getIntent();
        ordM=(OrderM) i.getSerializableExtra("obj");

        nroTable=findViewById(R.id.ord_det_nroTable);
        total=findViewById(R.id.ord_det_total);
        nroTable.setText(""+ordM.getNroTable());
        total.setText(""+ordM.getTotal());

        rv_orderDetails=findViewById(R.id.rv_order_det);
        rv_orderDetails.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL ));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_orderDetails.setLayoutManager(linearLayoutManager);

        adapter=new AdapterOrderDetails(ordM.getOrders());
        rv_orderDetails.setAdapter(adapter);


    }
}

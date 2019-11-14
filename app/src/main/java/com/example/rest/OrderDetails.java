package com.example.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.models.OrderM;

public class OrderDetails extends AppCompatActivity {


    OrderM ordM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        Intent i=getIntent();
        ordM=(OrderM) i.getSerializableExtra("obj");


        //orden= (OrderM) getIntent().getSerializableExtra("obj");


    }
}

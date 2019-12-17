package com.example.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import com.example.rest.kitchenActivities.Kitchen;
import com.example.rest.menuactivities.Menu;
import com.example.rest.orderactivities.OrderQueue;

public class MainActivity extends AppCompatActivity {

    Button menu,order,kitchen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //buttons
    public void menu(View view){
        Intent menu=new Intent(this, Menu.class);
        startActivity(menu);
    }
    public void orderQueue(View view){
        Intent orderQueue=new Intent(this, OrderQueue.class);
        startActivity(orderQueue);
    }
    public void Kitchen(View view){
        Intent kitchen=new Intent(this, Kitchen.class);
        startActivity(kitchen);
    }

}


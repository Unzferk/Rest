package com.example.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Button menu,order,option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //buttons
    public void menu(View view){
        Intent menu=new Intent(this,Menu.class);
        startActivity(menu);
    }
    public void orderQueue(View view){
        Intent orderQueue=new Intent(this,OrderQueue.class);
        startActivity(orderQueue);
    }
}


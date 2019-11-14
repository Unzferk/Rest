package com.example.rest;

import android.content.Intent;
import android.os.Bundle;

import com.example.models.OrderM;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class OrderQueue extends AppCompatActivity {

    //Attributes
    List<OrderM> orders;
    RecyclerView rv_OrderQueue;
    AdapterOrderQueue adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_queue);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newOrder();
            }
        });

        //recycler
        rv_OrderQueue =findViewById(R.id.order_queue_list);
        rv_OrderQueue.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL ));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_OrderQueue.setLayoutManager(linearLayoutManager);

        //loadData
        orders=new ArrayList<>();
        adapter=new AdapterOrderQueue(orders);
        rv_OrderQueue.setAdapter(adapter);

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

        firebaseDatabase.getReference().getRoot().child("order").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                orders.removeAll(orders);
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    //no at the moment.
                    OrderM aux=snapshot.getValue(OrderM.class);
                    orders.add(aux);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void newOrder(){
        Intent newOrder=new Intent(this,Order.class);
        startActivity(newOrder);
    }

}

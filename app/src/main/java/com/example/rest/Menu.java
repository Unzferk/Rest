package com.example.rest;

import android.os.Bundle;

import com.example.models.Food;
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
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    RecyclerView rv_dishList;
    List<Food> foods;
    AdapterDishList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Float add button
        FloatingActionButton fab = findViewById(R.id.add_plate);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDish();
            }
        });

        //recycler
        rv_dishList=findViewById(R.id.dish_list);
        rv_dishList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL ));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_dishList.setLayoutManager(linearLayoutManager);



        //loadData
        foods=new ArrayList<>();
        adapter=new AdapterDishList(foods);
        rv_dishList.setAdapter(adapter);

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

        firebaseDatabase.getReference().getRoot().child("food").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                foods.removeAll(foods);
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Food f=snapshot.getValue(Food.class);
                    foods.add(f);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void addDish(){
        Intent addDish=new Intent(this,AddDish.class);
        startActivity(addDish);
    }

}

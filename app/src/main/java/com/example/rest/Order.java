package com.example.rest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.models.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {

    //Attributes

    RecyclerView rv_OrderList;
    List<Food> foods;
    AdapterOrderList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //recycler
        rv_OrderList =findViewById(R.id.order_dish_list);
        rv_OrderList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL ));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_OrderList.setLayoutManager(linearLayoutManager);


        //loadData
        foods=new ArrayList<>();
        adapter=new AdapterOrderList(foods);
        rv_OrderList.setAdapter(adapter);


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

    //adding Toolbar
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_okay, (android.view.Menu) menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();
        if(id==R.id.btn_okay){

            Toast.makeText(Order.this,"data Inserted",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}

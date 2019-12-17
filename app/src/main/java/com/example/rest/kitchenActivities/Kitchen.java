package com.example.rest.kitchenActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.models.OrderList;
import com.example.rest.R;
import com.example.rest.adapters.AdapterKitchenQueue;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Kitchen extends AppCompatActivity {

    List<OrderList> orders;
    RecyclerView rv_KitchenQueue;
    AdapterKitchenQueue adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        rv_KitchenQueue =findViewById(R.id.kitch_orderQueue);
        rv_KitchenQueue.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL ));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_KitchenQueue.setLayoutManager(linearLayoutManager);

        orders=new ArrayList<>();
        adapter=new AdapterKitchenQueue(orders);
        rv_KitchenQueue.setAdapter(adapter);

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

        firebaseDatabase.getReference().getRoot().child("order").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                orders.removeAll(orders);
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    OrderList aux=snapshot.getValue(OrderList.class);
                    orders.add(aux);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}

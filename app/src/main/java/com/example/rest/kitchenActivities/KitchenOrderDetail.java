package com.example.rest.kitchenActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.models.OrderList;
import com.example.rest.R;
import com.example.rest.adapters.AdapterKitchOrdDetails;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KitchenOrderDetail extends AppCompatActivity {


    RecyclerView rv_orderDetails;
    AdapterKitchOrdDetails adapter;
    OrderList ordM;
    Button orderDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_order_detail);

        Intent i=getIntent();
        ordM=(OrderList) i.getSerializableExtra("obj");


        orderDone=findViewById(R.id.btn_finished);
        if(!ordM.isDone()){
            orderDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isDone();
                    Toast.makeText(KitchenOrderDetail.this, "Order is ready!!", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            orderDone.setEnabled(false);
        }


        rv_orderDetails=findViewById(R.id.rv_kit_ord_cont);
        rv_orderDetails.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL ));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_orderDetails.setLayoutManager(linearLayoutManager);

        adapter=new AdapterKitchOrdDetails(ordM.getOrders());
        rv_orderDetails.setAdapter(adapter);
    }

    public void isDone(){
        String key=ordM.getId();
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("order");
        databaseReference.child(key);
        ordM.setDone(true);
        databaseReference.child(key).setValue(ordM);
    }
}

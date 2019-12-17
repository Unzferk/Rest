package com.example.rest.orderactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.models.OrderList;
import com.example.rest.R;
import com.example.rest.adapters.AdapterOrderDetails;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderDetails extends AppCompatActivity {

    //Attributes
    TextView nroTable,total;
    RecyclerView rv_orderDetails;
    AdapterOrderDetails adapter;
    Button completed;

    OrderList ordM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);


        Intent i=getIntent();
        ordM=(OrderList) i.getSerializableExtra("obj");

        completed=findViewById(R.id.btn_order_complete);
        nroTable=findViewById(R.id.ord_det_nroTable);
        total=findViewById(R.id.ord_det_total);
        nroTable.setText("Table: "+ordM.getNroTable());
        total.setText("Total: "+ordM.getTotal());

        rv_orderDetails=findViewById(R.id.rv_order_det);
        rv_orderDetails.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL ));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_orderDetails.setLayoutManager(linearLayoutManager);

        adapter=new AdapterOrderDetails(ordM.getOrders());
        rv_orderDetails.setAdapter(adapter);

        if(ordM.isDone()){
            completed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delete(ordM.getId());
                }
            });
        }else {
            completed.setEnabled(false);
        }

    }
    private void delete(String key){
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("order").child(key);
        databaseReference.removeValue();
        Toast.makeText(OrderDetails.this,"Deleted",Toast.LENGTH_SHORT).show();
        finish();
    }
}

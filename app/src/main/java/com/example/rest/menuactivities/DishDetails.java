package com.example.rest.menuactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.models.Food;
import com.example.rest.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DishDetails extends AppCompatActivity {

    EditText name,price,desc;
    Button update,delete;
    DatabaseReference databaseReference;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);

        Intent i=getIntent();
        food=(Food) i.getSerializableExtra("obj");

        name=(EditText) findViewById(R.id.et_dish_name);
        price=(EditText) findViewById(R.id.et_dish_price);
        desc=(EditText) findViewById(R.id.et_dish_desc);
        update=(Button) findViewById(R.id.btn_updateDish);
        delete=(Button) findViewById(R.id.btn_deleteDish);

        name.setText(food.getName());
        name.setEnabled(false);
        price.setText(food.getPrice()+"");
        desc.setText(food.getDescription());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux=price.getText().toString();
                int p=Integer.parseInt(aux);
                update(name.getText().toString(),desc.getText().toString(),p);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(name.getText().toString());
            }
        });

    }

    private void update(String key,String desc,int mon){
        String id=key;
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("food").child(id);
        Food food=new Food(key,desc,mon);
        databaseReference.setValue(food);
        Toast.makeText(DishDetails.this,"Updated",Toast.LENGTH_SHORT).show();
        finish();
    }
    private void delete(String key){
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("food").child(key);
        databaseReference.removeValue();
        Toast.makeText(DishDetails.this,"Deleted",Toast.LENGTH_SHORT).show();
        finish();
    }
}

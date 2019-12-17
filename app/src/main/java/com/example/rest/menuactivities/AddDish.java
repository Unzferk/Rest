package com.example.rest.menuactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.models.Food;
import com.example.rest.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDish extends AppCompatActivity {

    EditText name,price,desc;
    Button create;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);
    }

    //adding Toolbar
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_okay, (android.view.Menu) menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        databaseReference= FirebaseDatabase.getInstance().getReference();

        int id=item.getItemId();
        if(id==R.id.btn_okay){
            name=(EditText) findViewById(R.id.input_dish_name);
            price =(EditText) findViewById(R.id.input_dish_price);
            desc=(EditText) findViewById(R.id.input_dish_desc);
            String nameS = name.getText().toString();
            String priceS = price.getText().toString();
            String descS = desc.getText().toString();
            if(nameS.isEmpty() || priceS.isEmpty() || descS.isEmpty()){
                Toast.makeText(AddDish.this,"some field is missing",Toast.LENGTH_SHORT).show();
            }else{
                String aux=price.getText().toString();
                int p=Integer.parseInt(aux);
                Food food=new Food(name.getText().toString(),desc.getText().toString(),p);
                databaseReference.child("food").child(name.getText().toString()).setValue(food);
                Toast.makeText(AddDish.this,"data Inserted",Toast.LENGTH_SHORT).show();
                name.setText("");
                price.setText("");
                desc.setText("");
            }
        }
        return true;
    }

}

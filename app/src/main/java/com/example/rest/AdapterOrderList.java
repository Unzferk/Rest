package com.example.rest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Food;
import com.example.models.OrderDish;

import java.util.List;

public class AdapterOrderList extends RecyclerView.Adapter<AdapterOrderList.OrderListViewHolder>{

    List<Food> foods;
    List<OrderDish> dishes;

    public AdapterOrderList(List<Food> foods,List<OrderDish> dishes){
        this.foods = foods;
        this.dishes = dishes;
    }

    @NonNull
    @Override
    public OrderListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int viewOrderDishRow=R.layout.dish_order_row;
        View aux= LayoutInflater.from(parent.getContext()).inflate(viewOrderDishRow,parent,false);
        OrderListViewHolder holder=new OrderListViewHolder(aux);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderListViewHolder holder, int position) {
        final Food food=foods.get(position);
        holder.dishName.setText(food.getName());
        String auxPrice=food.getPrice()+"";
        holder.dishPrice.setText(auxPrice);
        holder.flag.setChecked(false);



        holder.flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String auxS = holder.amount.getText().toString();
                if((!auxS.isEmpty())){
                    int amon = Integer.parseInt(auxS);
                    if(amon>0){
                        if(((CheckBox) v).isChecked()){
                        //cantidad de platos, revisar... deberia ser minimo 1
                        OrderDish aux=new OrderDish(food.getName(),food.getPrice(),amon);
                        dishes.add(aux);
                        holder.amount.setEnabled(!((CheckBox) v).isChecked());
                        System.out.println("Plato añadido :V");
                        }else{
                            holder.amount.setEnabled(!((CheckBox) v).isChecked());
                            holder.amount.setText("");
                            for(int i=0;i<dishes.size();i++){
                                if(dishes.get(i).getName().equals(food.getName())){
                                dishes.remove(i);
                                System.out.println("plato removido");
                                }
                            }
                        }
                    }else{((CheckBox)v).setChecked(false);}
                }else{
                    if(((CheckBox) v).isChecked()){
                        dishes.add(new OrderDish(food.getName(),food.getPrice(),1));
                        holder.amount.setText("1");
                        holder.amount.setEnabled(!((CheckBox) v).isChecked());
                    }
                    //((CheckBox)v).setChecked(false);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }


    class OrderListViewHolder extends RecyclerView.ViewHolder{

        TextView dishName,dishPrice;
        CheckBox flag;
        EditText amount;
        EditText nroTable;

        public OrderListViewHolder(@NonNull View itemView) {
            super(itemView);
            nroTable=itemView.findViewById(R.id.input_noTable);
            dishName=itemView.findViewById(R.id.dishNameOrderRow);
            dishPrice=itemView.findViewById(R.id.dishPriceOrderRow);
            flag=itemView.findViewById(R.id.check_add);
            amount=itemView.findViewById(R.id.et_amount);
        }
    }
}

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

import java.util.List;

public class AdapterOrderList extends RecyclerView.Adapter<AdapterOrderList.OrderListViewHolder>{

    List<Food> foods;

    public AdapterOrderList(List<Food> foods) {
        this.foods = foods;
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
        Food food=foods.get(position);
        holder.dishName.setText(food.getName());
        String auxPrice=food.getPrice()+"";
        holder.dishPrice.setText(auxPrice);
        holder.flag.setChecked(false);

        holder.flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fuck logic here
                holder.flag.setChecked(true);
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

        public OrderListViewHolder(@NonNull View itemView) {
            super(itemView);
            dishName=itemView.findViewById(R.id.dishNameOrderRow);
            dishPrice=itemView.findViewById(R.id.dishPriceOrderRow);
            flag=itemView.findViewById(R.id.check_add);
            amount=itemView.findViewById(R.id.et_amount);
        }
    }
}

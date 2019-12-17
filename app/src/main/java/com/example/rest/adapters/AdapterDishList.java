package com.example.rest.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Food;
import com.example.rest.menuactivities.DishDetails;
import com.example.rest.R;

import java.util.List;

public class AdapterDishList extends RecyclerView.Adapter<AdapterDishList.DishListViewHolder>{

    List<Food> foods;


    public AdapterDishList(List<Food> foods){
        this.foods=foods;
    }

    @NonNull
    @Override
    public DishListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int viewListDishRow= R.layout.dish_menu_row;
        View aux= LayoutInflater.from(parent.getContext()).inflate(viewListDishRow,parent,false);
        DishListViewHolder holder=new DishListViewHolder(aux);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DishListViewHolder holder, int position) {
        Food food=foods.get(position);
        holder.dishName.setText(food.getName());
        holder.dishDesc.setText(food.getDescription());

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }


    class DishListViewHolder extends RecyclerView.ViewHolder {

        TextView dishName,dishDesc;

        public DishListViewHolder(@NonNull View itemView) {
            super(itemView);
            dishName=itemView.findViewById(R.id.dishNameOrderRow);
            dishDesc=itemView.findViewById(R.id.tv_dish_desc);
           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), DishDetails.class);
                    i.putExtra("obj",foods.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });

        }
    }
}

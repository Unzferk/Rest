package com.example.rest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Food;

import java.util.List;

public class AdapterDishList extends RecyclerView.Adapter<AdapterDishList.DishListViewHolder>{

    List<Food> foods;


    public AdapterDishList(List<Food> foods){
        this.foods=foods;
    }

    @NonNull
    @Override
    public DishListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int viewListDishRow=R.layout.dish_menu_row;
        View aux= LayoutInflater.from(parent.getContext()).inflate(viewListDishRow,parent,false);
        DishListViewHolder holder=new DishListViewHolder(aux);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DishListViewHolder holder, int position) {
        Food food=foods.get(position);
        holder.dishName.setText(food.getName());

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }


    class DishListViewHolder extends RecyclerView.ViewHolder {

        TextView dishName;

        public DishListViewHolder(@NonNull View itemView) {
            super(itemView);
            dishName=itemView.findViewById(R.id.dishNameOrderRow);

        }
        void bind(){
            //se encarga de encajar el diseño de la fila en cada fila
        }
    }
}

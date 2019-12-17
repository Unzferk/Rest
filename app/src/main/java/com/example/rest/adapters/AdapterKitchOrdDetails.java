package com.example.rest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.OrderDish;
import com.example.rest.R;

import java.util.List;

public class AdapterKitchOrdDetails extends RecyclerView.Adapter<AdapterKitchOrdDetails.KitchOrdDetailViewHolder> {

    List<OrderDish> orderDishes;

    public AdapterKitchOrdDetails(List<OrderDish> orderDishes) {
        this.orderDishes = orderDishes;
    }

    @NonNull
    @Override
    public KitchOrdDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int viewKitchOrderDetailRow= R.layout.kitch_order_detail_row;
        View aux= LayoutInflater.from(parent.getContext()).inflate(viewKitchOrderDetailRow,parent,false);
        KitchOrdDetailViewHolder holder=new KitchOrdDetailViewHolder(aux);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KitchOrdDetailViewHolder holder, int position) {
        OrderDish dish=orderDishes.get(position);
        holder.dName.setText(dish.getName());
        holder.dAmount.setText(""+dish.getAmount());
    }

    @Override
    public int getItemCount() {
        return orderDishes.size();
    }


    class KitchOrdDetailViewHolder extends RecyclerView.ViewHolder {
        TextView dName,dAmount;

        public KitchOrdDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            dName=itemView.findViewById(R.id.k_det_name);
            dAmount=itemView.findViewById(R.id.k_det_amount);

        }
    }
}

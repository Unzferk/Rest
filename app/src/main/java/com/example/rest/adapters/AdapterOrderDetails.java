package com.example.rest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.OrderDish;
import com.example.models.OrderList;
import com.example.rest.R;

import java.util.List;

public class AdapterOrderDetails extends RecyclerView.Adapter<AdapterOrderDetails.OrderDetailsViewHolder>{


    List<OrderDish> orderDishes;
    OrderList ordM;

    public AdapterOrderDetails(List<OrderDish> orderDishes) {
        this.orderDishes = orderDishes;
    }

    @NonNull
    @Override
    public OrderDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int viewOrderDetailRow= R.layout.order_detail_row;
        View aux= LayoutInflater.from(parent.getContext()).inflate(viewOrderDetailRow,parent,false);
        OrderDetailsViewHolder holder=new OrderDetailsViewHolder(aux);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailsViewHolder holder, int position) {
        OrderDish dish=orderDishes.get(position);
        holder.dName.setText(dish.getName());
        holder.dAmount.setText(""+dish.getAmount());
        holder.dPUnit.setText(""+dish.getPrice());
        holder.dTotal.setText(""+dish.getSubTotal());

    }

    @Override
    public int getItemCount() {
        return orderDishes.size();
    }

    class OrderDetailsViewHolder extends RecyclerView.ViewHolder{

        TextView dName,dAmount,dPUnit,dTotal;

        public OrderDetailsViewHolder(@NonNull View itemView) {
            super(itemView);

            dName=itemView.findViewById(R.id.det_name);
            dAmount=itemView.findViewById(R.id.det_amount);
            dPUnit=itemView.findViewById(R.id.det_p_unit);
            dTotal=itemView.findViewById(R.id.det_total);
        }
    }
}

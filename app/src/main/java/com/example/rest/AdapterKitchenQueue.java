package com.example.rest;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.OrderM;

import java.util.List;

public class AdapterKitchenQueue extends RecyclerView.Adapter<AdapterKitchenQueue.KitchenQueueViewHolder> {

    List<OrderM> orders;

    public AdapterKitchenQueue(List<OrderM> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public KitchenQueueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int viewKitchenQueueRow=R.layout.kitch_order_queue_row;
        View aux= LayoutInflater.from(parent.getContext()).inflate(viewKitchenQueueRow,parent,false);
        KitchenQueueViewHolder holder=new KitchenQueueViewHolder(aux);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KitchenQueueViewHolder holder, int position) {
        OrderM order=orders.get(position);
        holder.nroTable.setText("Table - "+order.getNroTable());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    class KitchenQueueViewHolder extends RecyclerView.ViewHolder{

        TextView nroTable;
        public KitchenQueueViewHolder(@NonNull View itemView) {
            super(itemView);
            nroTable=itemView.findViewById(R.id.kitch_ntable_que);
            //click logic missing
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),KitchenOrderDetail.class);
                    i.putExtra("obj",orders.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}

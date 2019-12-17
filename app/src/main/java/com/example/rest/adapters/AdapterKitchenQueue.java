package com.example.rest.adapters;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.OrderList;
import com.example.rest.kitchenActivities.KitchenOrderDetail;
import com.example.rest.R;

import java.util.List;

public class AdapterKitchenQueue extends RecyclerView.Adapter<AdapterKitchenQueue.KitchenQueueViewHolder> {

    List<OrderList> orders;

    public AdapterKitchenQueue(List<OrderList> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public KitchenQueueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int viewKitchenQueueRow= R.layout.kitch_order_queue_row;
        View aux= LayoutInflater.from(parent.getContext()).inflate(viewKitchenQueueRow,parent,false);
        KitchenQueueViewHolder holder=new KitchenQueueViewHolder(aux);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull KitchenQueueViewHolder holder, int position) {
        OrderList order=orders.get(position);
        holder.nroTable.setText("Table - "+order.getNroTable());
        holder.orderDone();
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
                    Intent i = new Intent(v.getContext(), KitchenOrderDetail.class);
                    i.putExtra("obj",orders.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });
        }
        public void orderDone(){
            if(orders.get(getAdapterPosition()).isDone()){
                itemView.setBackgroundColor(Color.rgb(111, 252, 109));
            }else {
                itemView.setBackgroundColor(Color.rgb(255, 77, 64));
            }
        }
    }
}

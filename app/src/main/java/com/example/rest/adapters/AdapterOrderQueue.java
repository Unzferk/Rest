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
import com.example.rest.orderactivities.OrderDetails;
import com.example.rest.R;


import java.util.List;

public class AdapterOrderQueue extends RecyclerView.Adapter<AdapterOrderQueue.OrderQueueViewHolder> {


    List<OrderList> queueOrder;

    public AdapterOrderQueue(List<OrderList> queueOrder) {
        this.queueOrder = queueOrder;
    }

    @NonNull
    @Override
    public OrderQueueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int viewOrderQueueRow= R.layout.order_queue_row;
        View aux= LayoutInflater.from(parent.getContext()).inflate(viewOrderQueueRow,parent,false);
        OrderQueueViewHolder holder=new OrderQueueViewHolder(aux);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderQueueViewHolder holder, int position) {
        OrderList order=queueOrder.get(position);
        String aux=order.getNroTable()+"";
        holder.nroTable.setText("Table-"+aux);
        aux=order.getTotal()+"";
        holder.totalPrice.setText(aux);
        holder.orderDone();
    }

    @Override
    public int getItemCount() {
        return queueOrder.size();
    }

    class OrderQueueViewHolder extends RecyclerView.ViewHolder {

        TextView nroTable, totalPrice;

        public OrderQueueViewHolder(@NonNull View itemView) {
            super(itemView);
            nroTable =itemView.findViewById(R.id.nroTableQueueRow);
            totalPrice =itemView.findViewById(R.id.totalQueOrderRow);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), OrderDetails.class);
                    i.putExtra("obj",queueOrder.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });
        }
        public void orderDone(){
            if(queueOrder.get(getAdapterPosition()).isDone()){
                itemView.setBackgroundColor(Color.rgb(111, 252, 109));
            }else {
                itemView.setBackgroundColor(Color.rgb(255, 77, 64));
            }
        }
    }

}

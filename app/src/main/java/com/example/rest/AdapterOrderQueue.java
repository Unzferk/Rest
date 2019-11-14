package com.example.rest;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.models.OrderDish;
import com.example.models.OrderM;


import java.util.List;

public class AdapterOrderQueue extends RecyclerView.Adapter<AdapterOrderQueue.OrderQueueViewHolder> {


    List<OrderM> queueOrder;

    public AdapterOrderQueue(List<OrderM> queueOrder) {
        this.queueOrder = queueOrder;
    }

    @NonNull
    @Override
    public OrderQueueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int viewOrderQueueRow=R.layout.order_queue_row;
        View aux= LayoutInflater.from(parent.getContext()).inflate(viewOrderQueueRow,parent,false);
        OrderQueueViewHolder holder=new OrderQueueViewHolder(aux);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderQueueViewHolder holder, int position) {
        OrderM order=queueOrder.get(position);
        String aux=order.getNroTable()+"";
        holder.nroTable.setText("Table-"+aux);
        aux=order.getTotal()+"";
        holder.totalPrice.setText(aux);


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
                    Intent i = new Intent(v.getContext(),OrderDetails.class);
                    i.putExtra("obj",queueOrder.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });
        }
    }

}

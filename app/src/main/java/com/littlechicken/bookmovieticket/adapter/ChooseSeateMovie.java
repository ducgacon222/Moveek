package com.littlechicken.bookmovieticket.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.api.Data;
import com.littlechicken.bookmovieticket.databinding.ItemSeatBinding;
import com.littlechicken.bookmovieticket.databinding.ItemSelelectedBinding;

import java.util.List;

/**
 * Created by CanhNamDinh
 * on 16,December,2021
 */
public class ChooseSeateMovie extends RecyclerView.Adapter<ChooseSeateMovie.ViewHolder> {
    private List<Data> list;

    public void setList(List<Data> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChooseSeateMovie.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemSeatBinding itemBookBinding = ItemSeatBinding.inflate(layoutInflater, parent, false);
        return new ChooseSeateMovie.ViewHolder(itemBookBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseSeateMovie.ViewHolder holder, int position) {
        Data blog = list.get(position);
        holder.itemView.setItem(blog);
        holder.itemView.seate.setText(blog.getSeate() + position);
        holder.itemView.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemSeatBinding itemView;

        public ViewHolder(@NonNull ItemSeatBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }
}

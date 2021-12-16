package com.littlechicken.bookmovieticket.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.api.Data;
import com.littlechicken.bookmovieticket.databinding.ItemSelelectedBinding;

import java.util.List;

/**
 * Created by CanhNamDinh
 * on 16,December,2021
 */
public class ChooseDayAdapter extends RecyclerView.Adapter<ChooseDayAdapter.ViewHolder> {
    private List<Data> list;

    public void setList(List<Data> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemSelelectedBinding itemBookBinding = ItemSelelectedBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBookBinding);
    }

    @Override
    public void onBindViewHolder(ChooseDayAdapter.ViewHolder holder, int position) {
        Data blog = list.get(position);
        holder.itemBookBinding.setItem(blog);
        holder.itemBookBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemSelelectedBinding itemBookBinding;

        public ViewHolder(ItemSelelectedBinding itemBookBinding) {
            super(itemBookBinding.getRoot());
            this.itemBookBinding = itemBookBinding;
        }
    }
}

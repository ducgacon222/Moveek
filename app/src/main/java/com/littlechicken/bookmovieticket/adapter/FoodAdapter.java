package com.littlechicken.bookmovieticket.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.databinding.ItemFoodBinding;
import com.littlechicken.bookmovieticket.databinding.ItemSeatBinding;
import com.littlechicken.bookmovieticket.model.Food;

import java.util.List;

/**
 * Created by CanhNamDinh
 * on 19,December,2021
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private List<Food> list;
    private onClickItem item;


    public void setItem(onClickItem item) {
        this.item = item;
    }

    public onClickItem getItem() {
        return item;
    }

    public void setList(List<Food> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemFoodBinding itemBookBinding = ItemFoodBinding.inflate(layoutInflater, parent, false);
        return new FoodAdapter.ViewHolder(itemBookBinding);
    }

    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder holder, int position) {
        holder.itemView.setItem(list.get(position));
        holder.itemView.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemFoodBinding itemView;


        public ViewHolder(ItemFoodBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
            this.itemView.imgFilmitemHome.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            item.onClickFood(list.get(getAdapterPosition()));
        }
    }

    public interface onClickItem {
        void onClickFood(Food food);
    }
}

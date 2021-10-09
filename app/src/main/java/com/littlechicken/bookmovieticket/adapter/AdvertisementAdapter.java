package com.littlechicken.bookmovieticket.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.github.islamkhsh.CardSliderAdapter;
import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.model.Advertisement;

import java.util.ArrayList;

public class AdvertisementAdapter extends CardSliderAdapter<AdvertisementAdapter.AdvertisementViewHolder> {

    private ArrayList<Advertisement> advertisementList;

    public AdvertisementAdapter(ArrayList<Advertisement> advertisementList){
        this.advertisementList = advertisementList;
    }

    @Override
    public int getItemCount(){
        return advertisementList.size();
    }

    @Override
    public AdvertisementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advertisement_card_item, parent, false);
        return new AdvertisementViewHolder(view);
    }

    @Override
    public void bindVH(AdvertisementViewHolder movieViewHolder, int i) {

        Advertisement advertisement = advertisementList.get(i);
        movieViewHolder.poster.setImageResource(advertisement.getPoster());
    }

    class AdvertisementViewHolder extends RecyclerView.ViewHolder {

        private ImageView poster;

        public AdvertisementViewHolder(View view){
            super(view);
            poster = view.findViewById(R.id.advertisement_poster);
        }
    }
}


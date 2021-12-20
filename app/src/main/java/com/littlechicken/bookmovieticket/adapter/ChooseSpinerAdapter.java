package com.littlechicken.bookmovieticket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.api.Data;
import com.littlechicken.bookmovieticket.databinding.ItemSinperBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CanhNamDinh
 * on 19,December,2021
 */
public class ChooseSpinerAdapter extends BaseAdapter {
    private List<Data> listSpiner;
    private Context context;
    private LayoutInflater inflter;


    public ChooseSpinerAdapter(List<Data> listSpiner, Context context) {
        this.listSpiner = listSpiner;
        this.context = context;
        inflter = (LayoutInflater.from(context));
    }

    public void setListSpiner(ArrayList<Data> listSpiner) {
        this.listSpiner = listSpiner;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        if (listSpiner != null) {
            return listSpiner.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.item_sinper, null);
        TextView names = view.findViewById(R.id.txt_spiner);
        names.setText(listSpiner.get(position).getName());
        return view;
    }


}


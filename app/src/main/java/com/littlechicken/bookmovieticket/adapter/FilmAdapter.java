package com.littlechicken.bookmovieticket.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.api.Data;
import com.littlechicken.bookmovieticket.custom.OnClickInterface;
import com.littlechicken.bookmovieticket.model.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Data> listFilm;
    private final OnClickInterface onClickInterface;

    public void setListFilm(ArrayList<Data> listFilm) {
        this.listFilm = listFilm;
        notifyDataSetChanged();
    }

    public FilmAdapter(Context context, ArrayList<Data> listFilm, OnClickInterface onClickInterface) {
        this.context = context;
        this.listFilm = listFilm;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.filmitem_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.ViewHolder holder, int position) {
        Data film = listFilm.get(position);
        if (film.getPosterImage() != null) {
//            Picasso.get()
//                    .load(film.getPosterImage())
//                    .into(holder.img);
        }
        holder.name.setText(film.getName());
    }

    @Override
    public int getItemCount() {
        if (listFilm != null) {
            return listFilm.size();
        }
        return 0;


    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView img;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_filmitem_home);
            name = itemView.findViewById(R.id.tv_name_filmitem_home);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickInterface.onClick(view, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            onClickInterface.onClick(view, getAdapterPosition(), true);
            return false;
        }
    }
}

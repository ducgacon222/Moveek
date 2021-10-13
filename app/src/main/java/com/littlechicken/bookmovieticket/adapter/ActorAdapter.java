package com.littlechicken.bookmovieticket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.custom.OnClickInterface;
import com.littlechicken.bookmovieticket.model.Actor;

import java.util.ArrayList;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Actor> listActor;
    private final OnClickInterface onClickInterface;

    public ActorAdapter(Context context, ArrayList<Actor> listActor, OnClickInterface onClickInterface) {
        this.context = context;
        this.listActor = listActor;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public ActorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.actoritem_infofilm, parent, false);
        ActorAdapter.ViewHolder viewHolder = new ActorAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActorAdapter.ViewHolder holder, int position) {
        Actor actor = listActor.get(position);
        holder.img.setImageResource(actor.getImg());
        holder.name.setText(actor.getName());
    }

    @Override
    public int getItemCount() {
        if(listActor != null)
        {
            return listActor.size();
        }
        else
        {
            return 0;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        ImageView img;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_actoritem_infofilm);
            name = itemView.findViewById(R.id.tv_name_actoritem_infofilm);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickInterface.onClick(view, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            onClickInterface.onClick(view,getAdapterPosition(),true);
            return false;
        }
    }
}

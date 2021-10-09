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
import com.littlechicken.bookmovieticket.model.Blog;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {
    Context context;
    ArrayList<Blog> listBlog;
    private final OnClickInterface onClickInterface;

    public BlogAdapter(Context context, ArrayList<Blog> listBlog, OnClickInterface onClickInterface) {
        this.context = context;
        this.listBlog = listBlog;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.blogitem_blog, parent, false);
        BlogAdapter.ViewHolder viewHolder = new BlogAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BlogAdapter.ViewHolder holder, int position) {
        Blog blog = listBlog.get(position);
        holder.img.setImageResource(blog.getImg());
        holder.title.setText(blog.getTitle());
    }

    @Override
    public int getItemCount() {
        if(listBlog != null)
        {
            return listBlog.size();
        }
        else
        {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        ImageView img;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_blogitem_blog);
            title = itemView.findViewById(R.id.tv_title_blogitem_blog);
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

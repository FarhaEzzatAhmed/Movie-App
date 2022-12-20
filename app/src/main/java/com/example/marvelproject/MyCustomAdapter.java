package com.example.marvelproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder>{
    Context ctx;
    List<Movie> movies ;

    public MyCustomAdapter(Context ctx, List<Movie> movies) {
        this.ctx = ctx;
        this.movies = movies;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View recyclerView = inflater.inflate(R.layout.item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(recyclerView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.realName.setText(movies.get(position).getName());
        holder.heroname.setText(movies.get(position).getName());
        Glide.with(ctx).load(movies.get(position).getImageurl()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ctx,MovieDetailsActivity.class);

                intent.putExtra("heroName",movies.get(holder.getAdapterPosition()).getName());
                intent.putExtra("realName",movies.get(holder.getAdapterPosition()).getRealname());
                intent.putExtra("heroImg",movies.get(holder.getAdapterPosition()).getImageurl());
                intent.putExtra("heroBio",movies.get(holder.getAdapterPosition()).getBio());

                ctx.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView realName,heroname ;
        public ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.realName= itemView.findViewById(R.id.realname);
            this.heroname= itemView.findViewById(R.id.heroName);
            this.img = itemView.findViewById(R.id.imageView);
        }
    }
}

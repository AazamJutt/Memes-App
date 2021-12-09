package com.example.memeshareapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.MemeViewHolder> {
    List<Meme> memes;
    Context context;

    public MemeAdapter(Context context, List<Meme> memes) {
        this.memes = memes;
        this.context = context;
    }


    @NonNull
    @Override
    public MemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meme_post, parent, false);
        return new MemeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemeViewHolder holder, int position) {
        Meme currMeme = memes.get(position);
        holder.setAuthor(currMeme.getAuthor());
        holder.setCaption(currMeme.getCaption());
        holder.setImage(currMeme.getUrl());
    }

    @Override
    public int getItemCount() {
        return memes.size();
    }

    public class MemeViewHolder extends RecyclerView.ViewHolder {
        TextView author;
        TextView caption;
        ImageView meme;
        View view;
        public MemeViewHolder(@NonNull View memeView) {
            super(memeView);
            this.view = memeView;
        }
        public void setAuthor(String author){
            this.author = view.findViewById(R.id.author);
            this.author.setText(author);
        }
        public void setCaption(String caption){
            this.caption = view.findViewById(R.id.caption);
            this.caption.setText(caption);
        }
        public void setImage(String url){
            this.meme = view.findViewById(R.id.memeImg);
            Glide.with(context).load(url).into(meme);
        }
    }
}

package com.example.memeshareapp;

import android.app.Activity;
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
    Activity context;

    public MemeAdapter(Activity context, List<Meme> memes) {
        this.memes = memes;
        this.context = context;
    }


    @NonNull
    @Override
    public MemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meme_post, parent, false);
        MemeViewHolder holder = new MemeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemeViewHolder holder, int position) {
        Meme currMeme = memes.get(position);
        holder.caption.setText(currMeme.getCaption());
        holder.author.setText(currMeme.getAuthor());
        if (position == memes.size() - 1)
            Glide.with(context).load(currMeme.url).into(holder.meme);
    }

    @Override
    public int getItemCount() {
        return memes.size();
    }

    public class MemeViewHolder extends RecyclerView.ViewHolder {
        TextView author;
        TextView caption;
        ImageView meme;
        ImageView likeBtn;
        ImageView launchBtn;
        ImageView shareBtn;

        public MemeViewHolder(@NonNull View memeView) {
            super(memeView);
            author = memeView.findViewById(R.id.author);
            caption = memeView.findViewById(R.id.caption);
            meme = memeView.findViewById(R.id.memeImg);
            likeBtn = memeView.findViewById(R.id.likeBtn);
            launchBtn = memeView.findViewById(R.id.launchBtn);
            shareBtn = memeView.findViewById(R.id.shareBtn);
        }
    }
}

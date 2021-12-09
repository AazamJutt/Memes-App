package com.example.memeshareapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.MemeViewHolder> {
    @NonNull
    @Override
    public MemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MemeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MemeViewHolder extends RecyclerView.ViewHolder {
        public MemeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

package com.example.memeshareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recylerView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recylerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        ArrayList<Meme> memes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Meme meme = new Meme("Sheed","Kese ho yar?","www.google.com","");
            memes.add(meme);
        }
        MemeAdapter memeAdapter = new MemeAdapter(memes);
        recylerView.setAdapter(memeAdapter);
        recylerView.setLayoutManager(layoutManager);

    }
}
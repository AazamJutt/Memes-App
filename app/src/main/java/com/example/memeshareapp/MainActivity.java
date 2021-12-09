package com.example.memeshareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {
    RecyclerView recylerView;
    LinearLayoutManager layoutManager;
    List<Meme> memes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recylerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        memes = new ArrayList<>();
        MemeAdapter memeAdapter = new MemeAdapter(this, memes);
        Log.d("TAG", "onCreate: memes = "+memes.size());
        recylerView.setAdapter(memeAdapter);
        recylerView.setLayoutManager(layoutManager);
        fetchMemes();
        memeAdapter.notifyDataSetChanged();
    }

    public void fetchMemes() {
        String url = "https://meme-api.herokuapp.com/gimme/wholesomememes/" + "4";

        // Initialize a new RequestQueue instance
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Initialize a new JsonArrayRequest instance
        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                Request.Method.GET,
                        url,
                        null,
                        response -> {

                            try {
                                JSONArray jsonArray = response.getJSONArray("memes");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject obj = jsonArray.getJSONObject(i);
                                    String author = obj.getString("author");
                                    String caption = obj.getString("title");
                                    String postLink = obj.getString("postLink");
                                    String imageUrl = obj.getString("url");
                                    Log.d("url", "fetchMemes: " + imageUrl);
                                    if(!imageUrl.endsWith("gif")) {
                                        Meme meme = new Meme(author, caption, imageUrl, postLink);
                                        memes.add(meme);
                                    }
                                }
                                Log.d("Response", "fetchMemes: "+response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        },
                        error -> Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show());
        requestQueue.add(jsonArrayRequest);
    }
}
package com.edureka.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = (RecyclerView) findViewById(R.id.my_recyclerView);

        RecyclerAdapter recyclerAdapter= new RecyclerAdapter(this);

        recyclerview.setAdapter(recyclerAdapter);

        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }
}
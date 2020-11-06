package com.example.myapplication.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

public class LinearRecyclerActivity extends AppCompatActivity {

    private RecyclerView mrvmain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler);

        mrvmain = (RecyclerView) findViewById(R.id.rv_main);
        mrvmain.setLayoutManager(new LinearLayoutManager(LinearRecyclerActivity.this));

    }
}
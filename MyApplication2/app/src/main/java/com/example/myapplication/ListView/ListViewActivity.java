package com.example.myapplication.ListView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.myapplication.R;


public class ListViewActivity extends Activity{

    private ListView mlv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mlv1 = (ListView) findViewById(R.id.lv_1);
        mlv1.setAdapter(new MyListViewAdapter(ListViewActivity.this));
    }
}

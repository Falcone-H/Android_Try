package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class ImageViewActivity extends AppCompatActivity {

    private ImageView miv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        miv2 = (ImageView) findViewById(R.id.iv_2);
        Glide.with(this).load("https://i0.hdslb.com/bfs/article/21c5434df50d8c953bf1cce3cb4715235e89ce2b.jpg@1320w_1320h.webp").into(miv2);
    }
}
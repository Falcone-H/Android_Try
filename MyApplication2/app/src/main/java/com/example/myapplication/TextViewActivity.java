package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView mtv3;
    private TextView mtv4;
    private TextView mtv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mtv3 = (TextView) findViewById(R.id.tv_3);
        mtv3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);  //中划线
        mtv3.getPaint().setAntiAlias(true); //去锯齿

        mtv4 = (TextView) findViewById(R.id.tv_4);
        mtv4.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线

        mtv5 = (TextView) findViewById(R.id.tv_5);

    }
}
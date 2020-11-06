package com.example.just_test;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class TitleLayout extends LinearLayout {
    private Button btn_back;
    private Button btn_edit;
    private TextView text_title;
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        btn_back = findViewById(R.id.btn_back);
        btn_edit = findViewById(R.id.btn_edit);

        btn_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });

        btn_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You clicked edit button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

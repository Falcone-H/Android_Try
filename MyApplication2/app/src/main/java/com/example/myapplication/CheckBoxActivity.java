package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mcb1;
    private CheckBox mcb2;
    private CheckBox mcb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mcb1 = (CheckBox) findViewById(R.id.cb_1);
        mcb2 = (CheckBox) findViewById(R.id.cb_2);
        mcb3 = (CheckBox) findViewById(R.id.cb_3);

        mcb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this,b?"Choose":"No choose",Toast.LENGTH_SHORT).show();
            }
        });

        mcb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this,b?"Choose":"No choose",Toast.LENGTH_SHORT).show();
            }
        });

        mcb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this,b?"Choose":"No choose",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
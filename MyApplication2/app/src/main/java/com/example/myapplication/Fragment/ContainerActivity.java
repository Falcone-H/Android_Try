package com.example.myapplication.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class ContainerActivity extends AppCompatActivity {


    private AFragment aFragment;
    private BFragment bFragment;
    private ImageButton btnChange;
    private boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        btnChange = (ImageButton) findViewById(R.id.btn_change);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){
                    flag = !flag;
                    if(bFragment == null){
                        bFragment = new BFragment();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,bFragment).commitAllowingStateLoss();
                }
                else{
                    flag = !flag;
                    if(aFragment == null){
                        aFragment = new AFragment();;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,aFragment).commitAllowingStateLoss();
                }

            }
        });

        aFragment = new AFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,aFragment).commitAllowingStateLoss();


    }
}
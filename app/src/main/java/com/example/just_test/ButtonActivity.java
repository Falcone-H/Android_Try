package com.example.just_test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ButtonActivity extends BaseActivity {

    private TextView text_1;
    private Button btn_getResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        init();
        boolean is_login = getIntent().getBooleanExtra("is_login", false);
        if (is_login) {
            text_1.setText("Login successfully!");
        } else {
            text_1.setText("Fail to login!");
        }
        btn_getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data", "return value");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


    private void init() {
        text_1 = findViewById(R.id.text_1);
        btn_getResult = findViewById(R.id.btn_getResult);
    }
}
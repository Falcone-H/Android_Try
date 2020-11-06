package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MediaActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button btn_start;
    private Runnable runnable;
    private Handler handler;
    int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        init();
        newRunnable();
        newHandler();
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_start.setEnabled(false);
                new Thread(runnable).start();
            }
        });
    }

    public void init() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btn_start = (Button) findViewById(R.id.btn_start);
    }

    public void newRunnable() {
        runnable = new Runnable() {
            @Override
            public void run() {
                Message message;
                try {
                    while (true) {
                        Thread.sleep(100);
                        step++;
                        message = new Message();
                        handler.sendMessage(message);
                        if (step > 100)
                            step = 0;
                    }
                }
                catch (Exception e) {
                    message = new Message();
                    message.obj = e;
                    handler.sendMessage(message);
                }
            }
        };
    }

    @SuppressLint("HandlerLeak")
    public void newHandler() {
        handler = new Handler() {
            public void handleMessage(Message message) {
                progressBar.setProgress(step);
            }
        };
    }
}
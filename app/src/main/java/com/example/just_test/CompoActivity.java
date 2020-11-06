package com.example.just_test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class CompoActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_control;
    private Button btn_alert;
    private Button btn_progress;
    private Button btn_percent;
    private Button btn_list;
    private Button btn_recycler;
    private ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compo);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        init();
        btn_control.setOnClickListener(this);
        btn_alert.setOnClickListener(this);
        btn_progress.setOnClickListener(this);
        btn_percent.setOnClickListener(this);
        btn_list.setOnClickListener(this);
        btn_recycler.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_control:
                int progress = progress_bar.getProgress();
                progress = progress + 10;
                progress_bar.setProgress(progress);
                break;
            case R.id.btn_alert:
                alert_dialog();
                break;
            case R.id.btn_progress:
                progress_dialog();
                break;
            case R.id.btn_percent:
                intent = new Intent(CompoActivity.this, PercentActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_list:
                intent = new Intent(CompoActivity.this, ListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_recycler:
                intent = new Intent(CompoActivity.this, RecyclerActivity.class);
                startActivity(intent);
        }
    }

    public void alert_dialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(CompoActivity.this);
        dialog.setTitle("This is a dialog!");
        dialog.setMessage("Something important!");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    public void progress_dialog(){
        ProgressDialog progressDialog = new ProgressDialog(CompoActivity.this);
        progressDialog.setTitle("This is ProgressDialog!");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    public void init() {
        btn_control = findViewById(R.id.btn_control);
        btn_alert = findViewById(R.id.btn_alert);
        btn_progress = findViewById(R.id.btn_progress);
        btn_percent = findViewById(R.id.btn_percent);
        btn_list = findViewById(R.id.btn_list);
        btn_recycler = findViewById(R.id.btn_recycler);
        progress_bar = findViewById(R.id.progress_bar);
    }
}
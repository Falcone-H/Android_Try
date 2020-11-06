package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Fragment.AFragment;
import com.example.myapplication.Fragment.ContainerActivity;
import com.example.myapplication.ListView.ListViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button mbtnTextView;
    private Button mbtnButton;
    private Button mbtnEditText;
    private Button mbtnRadioButton;
    private Button mbtnCheckBox;
    private Button mbtnImageView;
    private Button mbtnListView;
    private Button mbtnFragment;
    private Button mbtnRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mbtnTextView = (Button) findViewById(R.id.btn_textview);

        mbtnButton = (Button) findViewById(R.id.btn_button);

        mbtnEditText = (Button) findViewById(R.id.btn_edittext);

        mbtnRadioButton = (Button) findViewById(R.id.btn_radiobutton);

        mbtnCheckBox = (Button) findViewById(R.id.btn_checkbox);

        mbtnImageView = (Button) findViewById(R.id.btn_imageview);

        mbtnListView = (Button) findViewById(R.id.btn_listview);

        mbtnFragment = (Button) findViewById(R.id.btn_fragment);

        mbtnRecyclerView = (Button) findViewById(R.id.btn_recyclerview);

        setListeners();
    }


    private void setListeners(){
        OnClick onClick = new OnClick();
        mbtnTextView.setOnClickListener(onClick);
        mbtnButton.setOnClickListener(onClick);
        mbtnEditText.setOnClickListener(onClick);
        mbtnRadioButton.setOnClickListener(onClick);
        mbtnCheckBox.setOnClickListener(onClick);
        mbtnImageView.setOnClickListener(onClick);
        mbtnListView.setOnClickListener(onClick);
        mbtnFragment.setOnClickListener(onClick);
        mbtnRecyclerView.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_textview:
                    //跳转到TextView演示界面
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    //跳转到Button演示界面
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    //跳转到EditText演示界面
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    //跳转到RadioButton演示界面
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    //跳转到CheckBox演示界面
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    //跳转到ImageView演示界面
                    intent = new Intent(MainActivity.this,ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    //跳转到ListView演示界面
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_fragment:
                    //跳转到Fragment演示界面
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    //跳转到RecyclerView演示界面
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            }
            startActivity(intent);
        }
    }
}
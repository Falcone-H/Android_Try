package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    private MyDatabaseHelpter databaseHelpter;
    private Button btn_register;
    private EditText rg_username;
    private EditText rg_password;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = rg_username.getText().toString();
                databaseHelpter = new MyDatabaseHelpter(RegisterActivity.this, "user.db", null ,1);
                SQLiteDatabase db = databaseHelpter.getWritableDatabase();
                //根据username去数据库查询
                Cursor cursor = db.query("user_tb", null, "userID=?", new String[]{name},null,null,null);
                //如果查询到数据，则说明账号已存在
                if (cursor != null && cursor.getCount() >= 1){
                    Toast.makeText(RegisterActivity.this, "用户已存在", Toast.LENGTH_SHORT).show();
                    cursor.close();
                }
                //如果没有查询到数据，则加入
                else{
                    final String[] sex = new String[1];
                    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            RadioButton choise = (RadioButton) findViewById(i);
                            String text = choise.getText().toString();
                            sex[0] = text;
                        }
                    });
                    //获取当前时间
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date(System.currentTimeMillis());
                    String time = simpleDateFormat.format(date);

                    String pwd = rg_password.getText().toString();

                    ContentValues values = new ContentValues();
                    values.put("userID", name);
                    values.put("password", pwd);
                    values.put("sex", sex[0]);
                    values.put("date", time);
                    db.insert("user_tb", null, values);
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    RegisterActivity.this.finish();
                }
                db.close();
            }
        });
    }
    public void init(){
        btn_register = (Button) findViewById(R.id.btn_register);
        rg_username = (EditText) findViewById(R.id.rg_user_name);
        rg_password = (EditText) findViewById(R.id.rg_password);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }
}
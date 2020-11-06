package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private EditText user_name;
    private EditText password;
    private Button btn_login;
    private TextView tv_register;
    private TextView find_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelpter helpter = new MyDatabaseHelpter(LoginActivity.this, "user.db", null, 1);
                SQLiteDatabase db = helpter.getWritableDatabase();
                String name = user_name.getText().toString();
                String pwd = password.getText().toString();
                Cursor cursor = db.query("user_tb", null, "userID=? and password=?", new String[]{name, pwd}, null, null, null);
                if (cursor != null && cursor.getCount() >= 1){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    cursor.close();
                    db.close();
                    LoginActivity.this.finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "账号或密码输入错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void init(){
        user_name = (EditText) findViewById(R.id.et_user_name);
        password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_register = (TextView) findViewById(R.id.tv_register);
        find_password = (TextView) findViewById(R.id.tv_find_password);
    }
}
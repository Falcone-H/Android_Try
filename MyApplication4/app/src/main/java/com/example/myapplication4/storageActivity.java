package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.BatchUpdateException;
import java.util.Map;

public class storageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        //任意key以及对应value写入，全部key和value读取
        final EditText editText_key = (EditText) findViewById(R.id.editText_key);
        final EditText editText_value = (EditText) findViewById(R.id.editText_value);
        Button button_write = (Button) findViewById(R.id.button_write);
        Button button_read_all = (Button) findViewById(R.id.button_read_all);

        //name的value写入，name的value读取
        final EditText editText_name = (EditText) findViewById(R.id.editText_name);
        Button button_write_name = (Button) findViewById(R.id.button_write_name);
        Button button_read_name = (Button) findViewById(R.id.button_read_name);

        //age的value写入，age的value读取
        final EditText editText_age = (EditText) findViewById(R.id.editText_age);
        Button button_write_age = (Button) findViewById(R.id.button_write_age);
        Button button_read_age = (Button) findViewById(R.id.button_read_age);

        //内容显示
        final TextView textView_content = (TextView) findViewById(R.id.textView_content);

        //1、获取SharedPreferences对象。SharedPreferences是一个接口，程序无法直接创建SharedPreferences对象，只能通过Context提供的getSharedPreferences()方法。
        final SharedPreferences preferences = getSharedPreferences("test", MODE_PRIVATE);
        //2、获取SharedPreferences。Editor对象，用于写数据
        final SharedPreferences.Editor editor = preferences.edit();

        button_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = editText_key.getText().toString().trim();
                String value = editText_value.getText().toString().trim();
                //3、写入数据并commit
                editor.putString(key, value);
                editor.commit();
            }
        });

        //读取所有数据
        button_read_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = "";
                Map<String, ?> allContent = preferences.getAll();
                //遍历map
                for (Map.Entry<String, ?> entry : allContent.entrySet()){
                    content += ("key:" + entry.getKey() + "=" + entry.getValue() + ", ");
                }
                textView_content.setText(content);
            }
        });

        //name写入
        button_write_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = "name";
                String value = editText_name.getText().toString().trim();
                editor.putString(key, value);
                editor.commit();
            }
        });

        //name读取
        button_read_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = preferences.getString("name", "1111");
                textView_content.setText(content);
            }
        });

        //age写入
        button_write_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = "age";
                String value = editText_age.getText().toString().trim();
                editor.putString(key, value);
                editor.commit();
            }
        });

        //age读取
        button_read_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = preferences.getString("age", "17");
                textView_content.setText(content);
            }
        });
    }
}
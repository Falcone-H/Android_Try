package com.example.myapplication4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13;
    private int theChoice;
    private ArrayList<Integer> theChoices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btn11 = (Button) findViewById(R.id.button11);
        btn12 = (Button) findViewById(R.id.button12);
        btn13 = (Button) findViewById(R.id.button13);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNormalDialog();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showListDialog();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChoiceDialog();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMutiChoiceDialog();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditDialog();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });

        registerForContextMenu(btn7);

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建一个弹出式菜单对象
                PopupMenu popup = new PopupMenu(MainActivity.this, view);
                //填充菜单
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.main, popup.getMenu());
                //为弹出菜单设置菜单项单机监听器
                popup.setOnMenuItemClickListener(MainActivity.this);
                popup.show();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, storageActivity.class);
                startActivity(intent);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, listViewActivity.class);
                startActivity(intent);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(intent);
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
        return false;
    }

    private void showNormalDialog(){
        //普通对话框
        final AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);
        normalDialog.setTitle("普通Dialog");
        normalDialog.setMessage("你要点击哪一个按钮");
        normalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_LONG).show();

            }
        });
        normalDialog.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "no", Toast.LENGTH_LONG).show();
            }
        });
        //显示
        normalDialog.show();
    }

    private void showListDialog(){
        //列表对话框
        final String[] items = {"A", "B", "C", "D"};
        AlertDialog.Builder listDialog = new AlertDialog.Builder(MainActivity.this);
        listDialog.setTitle("列表对话框");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_LONG).show();
            }
        });
        listDialog.show();
    }

    private void showChoiceDialog(){
        //单选对话框
        final String[] items = {"1", "2", "3", "4"};
        theChoice = -1;
        AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(MainActivity.this);
        singleChoiceDialog.setTitle("单选Dialog");
        singleChoiceDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                theChoice = i;
            }
        });
        singleChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(theChoice != -1)
                    Toast.makeText(MainActivity.this, items[theChoice], Toast.LENGTH_LONG).show();
            }
        });
        singleChoiceDialog.show();
    }

    private void showMutiChoiceDialog(){
        //多选对话框
        final String[] items = {"华为", "三星", "魅族", "小米"};
        final boolean initChoicesets[] = {false, false, false, false};
        theChoices.clear();
        AlertDialog.Builder multiChoiceDialog = new AlertDialog.Builder(MainActivity.this);
        multiChoiceDialog.setTitle("多选Dialog");
        multiChoiceDialog.setMultiChoiceItems(items, initChoicesets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if (b)
                    theChoices.add(i);
                else
                    theChoices.remove(i);
            }
        });
        multiChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                int size = theChoices.size();
                String str = "";
                for(int i = 0; i < size; i++){
                    str += items[theChoices.get(i)] + " ";
                }
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }
        });
        multiChoiceDialog.show();
    }

    private void showEditDialog(){
        //输入对话框
        final EditText editText = new EditText(MainActivity.this);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(MainActivity.this);
        inputDialog.setTitle("输入Dialog").setView(editText);
        inputDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        inputDialog.show();
    }

    private void showCustomDialog(){
        //自定义对话框
        AlertDialog.Builder customDialog = new AlertDialog.Builder(MainActivity.this);
        final View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null);
        customDialog.setTitle("自定义Dialog");
        customDialog.setView(dialogView);
        customDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editText = (EditText) dialogView.findViewById(R.id.edit_text);
                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        customDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_start:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_setting:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_music:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_view:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_over:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.button7){
            getMenuInflater().inflate(R.menu.main, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }
}
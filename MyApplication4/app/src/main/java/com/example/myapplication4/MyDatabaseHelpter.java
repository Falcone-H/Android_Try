package com.example.myapplication4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelpter extends SQLiteOpenHelper {
    public static final String CREATE_USER = (
            "create table if not exists user_tb(_id integer primary key autoincrement," +
            "userID text not null," +
            "password text not null,"+"sex char(2),"+"phone char(11),"+"date date )");

    private Context mcontext;
    public MyDatabaseHelpter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER);
        Toast.makeText(mcontext, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

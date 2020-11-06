package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class listViewActivity extends AppCompatActivity {

    private List<ListBean> myBeanlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView) findViewById(R.id.listview);
        init();
        MyAdapter adapter = new MyAdapter(listViewActivity.this, R.layout.list_item, myBeanlist);
        listView.setAdapter(adapter);
    }

    private void init(){
        ListBean bean1 = new ListBean("aa", R.mipmap.ic_launcher);
        myBeanlist.add(bean1);

        ListBean bean2 = new ListBean("ss", R.mipmap.ic_launcher);
        myBeanlist.add(bean2);

        ListBean bean3 = new ListBean("bb", R.mipmap.ic_launcher);
        myBeanlist.add(bean3);
    }
}
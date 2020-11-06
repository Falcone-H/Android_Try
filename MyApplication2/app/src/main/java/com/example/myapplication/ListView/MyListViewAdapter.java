package com.example.myapplication.ListView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class MyListViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInfalter;
    public MyListViewAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle;
        public TextView tvTime;
        public TextView tvContent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            convertView = mLayoutInfalter.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();

            holder.imageView = (ImageView) convertView.findViewById(R.id.iv);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder) convertView.getTag();
        }

        //给控件赋值
        holder.tvTitle.setText("标题");
        holder.tvTime.setText("2088-88-88");
        holder.tvContent.setText("内容");
        Glide.with(mContext).load("https://i0.hdslb.com/bfs/article/21c5434df50d8c953bf1cce3cb4715235e89ce2b.jpg@1320w_1320h.webp").into(holder.imageView);

        return null;
    }
}

package com.example.myapplication4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter {
    private final int ImageId;
    public MyAdapter(Context context, int headImage, List<ListBean> obj){
        super(context, headImage, obj);
        ImageId = headImage;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListBean listBean = (ListBean) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(ImageId, null);
        LinearLayout linearLayout = view.findViewById(R.id.ll_view);
        ImageView headImage = view.findViewById(R.id.headimage);
        TextView headText = view.findViewById(R.id.headtext);
        headImage.setImageResource(listBean.getImageID());
        headText.setText(listBean.getText());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "第"+position+"个", Toast.LENGTH_SHORT).show();
            }
        });
       return view;
    }
}

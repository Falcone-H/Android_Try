package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Message> messageList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView recyclerView;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initMessage();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Message message = new Message(content, Message.TYPE_SENT);
                    messageList.add(message);
                    //当发送新消息时，刷新ListView显示
                    adapter.notifyItemInserted(messageList.size() - 1);
                    //将ListView定位到最后一行
                    recyclerView.scrollToPosition(messageList.size() - 1);
                    //清空输入框中的内容
                    inputText.setText("");
                }
            }
        });
    }

    private void init() {
        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.btn_send);
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void initMessage() {
        Message message1 = new Message("Hello guy!", Message.TYPE_RECEIVED);
        messageList.add(message1);
        Message message2 = new Message("Hello. Who is that?", Message.TYPE_SENT);
        messageList.add(message2);
        Message message3 = new Message("This is Tom. Nice to meet you!", Message.TYPE_RECEIVED);
        messageList.add(message3);
    }
}
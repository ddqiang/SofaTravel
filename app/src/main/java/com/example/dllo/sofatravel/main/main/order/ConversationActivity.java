package com.example.dllo.sofatravel.main.main.order;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.newim.bean.BmobIMConversation;
import cn.bmob.newim.bean.BmobIMMessage;
import cn.bmob.newim.bean.BmobIMTextMessage;
import cn.bmob.newim.core.BmobIMClient;
import cn.bmob.newim.event.MessageEvent;
import cn.bmob.newim.listener.MessageListHandler;
import cn.bmob.newim.listener.MessageSendListener;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by dllo on 16/7/25.
 */
public class ConversationActivity extends BaseActivity implements View.OnClickListener, MessageListHandler {
    private TextView titleName;
    private ConversationAdapter adapter;
    private ArrayList<ConversationBean> beans;
    private RecyclerView recyclerView;
    private Button sendBtn;
    private EditText sendText;
    private ImageView leftMenu, rightMenu;
    private BmobIMConversation conversation;
    private BmobIMTextMessage msg;
    private RecyclerView.LayoutManager manager;

    @Override
    public int getLayout() {
        return R.layout.activity_conversation;
    }

    @Override
    public void initView() {
        titleName = (TextView) findViewById(R.id.fragment_conversation_title_name);
        adapter = new ConversationAdapter(this);
        beans = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.fragment_conversation_recyclerview);
        sendBtn = (Button) findViewById(R.id.fragment_conversation_send_text);
        sendText = (EditText) findViewById(R.id.fragment_conversation_text_edit);
        leftMenu = (ImageView) findViewById(R.id.fragment_conversation_title_menu);
        rightMenu = (ImageView) findViewById(R.id.fragment_conversation_title_person_info);
        manager = new LinearLayoutManager(this);
        sendBtn.setOnClickListener(this);
        leftMenu.setOnClickListener(this);
        rightMenu.setOnClickListener(this);
    }

    @Override
    public void initData() {
        adapter.setBeans(beans);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        conversation = BmobIMConversation.obtain(BmobIMClient.getInstance(), (BmobIMConversation) getIntent().getExtras().get("c"));
        titleName.setText(conversation.getConversationTitle());
        msg = new BmobIMTextMessage();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_conversation_send_text:
                String text = sendText.getText().toString();
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
                msg.setContent(text);
                conversation.sendMessage(msg, new MessageSendListener() {
                    @Override
                    public void done(BmobIMMessage bmobIMMessage, BmobException e) {
                        if (e == null) {
                            ConversationBean bean = new ConversationBean();
                            bean.setSendUserName(msg.getFromId());
                            bean.setText(msg.getContent());
                            bean.setType(1);
                            beans.add(bean);
                            adapter.setBeans(beans);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(manager);
                        }
                    }
                });
                sendText.setText("");
                break;
            case R.id.fragment_conversation_title_menu:

                break;

            case R.id.fragment_conversation_title_person_info:

                break;
        }
    }

    @Override
    public void onMessageReceive(List<MessageEvent> list) {
        for (int i = 0; i < list.size(); i++) {
            Log.d("lanou", list.get(i).getMessage().getContent());
        }
    }
}

package com.wit.custombroadcasttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnotherActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private Button sendData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);
        initView();
    }

    private void initView(){
        editText = (EditText)findViewById(R.id.edit_text);
        sendData = (Button)findViewById(R.id.send_data);
        sendData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_data:
                //获取数据，并且往注册的广播器发送广播
                String data = editText.getText().toString();
                Intent intent = new Intent("com.wit.custombroadcasttest.DATA_TRANSPORT");
                intent.putExtra("data", data);
                //Log.d("wnw","here + " +data);
                //发送广播
                sendBroadcast(intent);
                break;
            default:
                break;
        }
    }
}

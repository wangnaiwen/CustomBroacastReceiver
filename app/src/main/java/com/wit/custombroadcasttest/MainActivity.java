package com.wit.custombroadcasttest;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wnw on 2016/8/29.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textView;
    private Button openOtherAty;

    private MReceiver mReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initView();
        initBroadcast();
    }

    private void initView(){
        textView = (TextView)findViewById(R.id.text_view);
        openOtherAty = (Button)findViewById(R.id.open_other_aty);
        openOtherAty.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.open_other_aty:
                Intent intent = new Intent(this, AnotherActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void initBroadcast(){
        //在这里加入需要监听的广播
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.wit.custombroadcasttest.DATA_TRANSPORT");
        mReceiver = new MReceiver();

        //在onCreate()方法中注册，在onDestroy（）方法中注销注册
        registerReceiver(mReceiver, intentFilter);
    }



    /**
     *在这里注册和监听自定义的广播
     *
     */

    class MReceiver extends CustomBroadcast{
        @Override
        public void onReceive(Context context, Intent intent) {
            //在这里获取数据，并且显示到Textview中
            String data = intent .getStringExtra("data");
            textView.setText(data);
            Log.d("wnw", data);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("wnw", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("wnw", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("wnw", "pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("wnw", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在这里取消注册
        unregisterReceiver(mReceiver);
        Log.d("wnw", "destroy");
    }

}

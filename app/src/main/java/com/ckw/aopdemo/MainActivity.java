package com.ckw.aopdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
        another();
    }

    @CheckLogin("test")
    public void test(){
        Log.d("----", "test:登录后的操作");
    }

    @CheckLogin("another")
    public void another(){
        Log.d("----", "test:登录后的操作");
    }
}

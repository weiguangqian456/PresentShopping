package com.example.presentshopping.config.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.example.presentshopping.net.manager.RxHttpManager;

public class MyApplication extends Application {


    private static Context mContext;
    private static MyApplication mInstance;

    public static MyApplication getInstance() {
        return mInstance;
    }

    // 当前线程id
    public static int mainThreadId;
    public static Handler handler;

    public static Context getContext() {

        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mContext = getApplicationContext();
        /**
         * RxHttp初始化
         */
        RxHttpManager.init(this);

    }
}

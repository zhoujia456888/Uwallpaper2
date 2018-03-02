package com.jloveh.uwallpaper;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.facebook.fresco.helper.Phoenix;
import com.jloveh.jlog.config.JLogConfig;
import com.jloveh.uwallpaper.Utils.CrashUtil;
import com.kc.unsplash.Unsplash;
import com.wanjian.cockroach.Cockroach;


/**
 * Created by zhoujia on 2018/2/27.
 */

public class MyApplication extends Application {
    private static MyApplication application;
    public static Unsplash unsplash;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;

        initCockroach();//Cockroach

        Utils.init(application);//AndroidUtils

        JLogConfig.buidler().setDebug(true).build();//Jlog

        unsplash = new Unsplash(Config.applicationID);//Unsplash

        Phoenix.init(this);//Phoenix

    }

    private void initCockroach() {
        //永不crash
        Cockroach.install(new Cockroach.ExceptionHandler() {
            @Override
            public void handlerException(final Thread thread, final Throwable throwable) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.e("AndroidRuntime", "--->CockroachException:" + thread + "<---", throwable);
                            if (BuildConfig.LOG_DEBUG) {
                                ToastUtils.showShort("" + thread + throwable);
                            }
                            // throw new RuntimeException("..."+(i++));
                            //收集设备参数信息
                            CrashUtil.collectDeviceInfo(application);
                            //保存日志文件
                            CrashUtil.saveCrashInfo2File(throwable);
                        } catch (Throwable e) {
                            Log.e("AndroidRuntime", "" + e);
                        }
                    }
                });
            }
        });
    }



}

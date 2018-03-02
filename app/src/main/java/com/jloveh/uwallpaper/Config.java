package com.jloveh.uwallpaper;


import android.os.Environment;

/**
 * Created by zhoujia on 2018/2/27.
 */

public class Config {

    public static String applicationID = "24d27e40710fcc0e45a3922a7917c70f282ceccad10986193d1b2288f6ae8032";
    String secret = "2195a2c63b57eeb866c4c5d9fe80c777cfef2b857fdf014f940f66cba0450d98";

    //SD卡文件保存地址
    public static String FilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Uwallpaper/";


}

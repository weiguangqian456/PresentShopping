package com.example.presentshopping.config.constant;

import java.text.DecimalFormat;

public class Constant {
    public static final String LOGGER = "logger";

    // 来自哪里的键
    public static final String FROM = "from";
    // 缓存用户所有的基本信息。
    public static final String UserInfor_Data = "UserInfor_Data";
    // 缓存登录获取的token
    public static final String SP_TOKEN = "token";

    // 网络请求类型
    public static final int requestType_post = 1000;   // 1000:post 请求
    public static final int requestType_get = 2000;   // 2000:get 请求
    public static final int requestType_Upload = 3000;   // 3000:文件上传
    public static final int requestType_Download = 4000;   // 4000:文件下载
    // 数据类型: X-WWW-FORM-URLENCODED
    public static final String contentType_form = "application/x-www-form-urlencoded;charset=UTF-8";
    public static final String contentType_json = "application/json;charset=utf-8";

    // 返回码说明
    public static final int CODE_Success = 0;   // 请求成功
    public static final int CODE_Failed = 500;   // 请求失败
    public static final int CODE_Failed_20201 = 1401;  // 请求失败（用户未登录）
    public static final int CODE_Failed_20202 = 1403;  // 请求失败（登录超时,请重新登录）
    public static final int CODE_Failed_20203 = 1404;  // 请求失败（账号被冻结）

    // 请求数据时填写的默认int值为：-1。
    public static final int Default_INT = -1;
    // 请求数据时填写的默认String值为：""。
    public static final String Default_STR = "";

    // 构造方法的字符格式这里如果小数不足2位,会以0补足.
    public static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    // 获取缓存的引导页标示（以版本号为标示）。
    public static final String GuidePage = "GuidePage";

}

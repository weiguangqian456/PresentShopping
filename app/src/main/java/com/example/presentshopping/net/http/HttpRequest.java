package com.example.presentshopping.net.http;

import android.text.TextUtils;
import android.util.Base64;


import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求参数。
 */
public class HttpRequest {
    // 全局请求头
    public static HashMap<String, Object> Headers(String contentType) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("accept", "*/*");// 数据接受类型
        if (!contentType.equals("") && contentType.length() != 0) {
            params.put("Content-Type", contentType);// 数据类型: X-WWW-FORM-URLENCODED
        }
        params.put("token", "IntentJumpUtils.getUsrToken()");// 公共参数，用户验证。
        return params;
    }

    //发送短信
    public static HashMap<String, Object> SendSms(String phone) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("mobile", phone);// phone	String	必填	手机号码
        return params;
    }

    // 用户登录
    public static HashMap<String, Object> Sendlogin(String phone, String code) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("mobile", phone);// phone	String	必填	手机号码
        params.put("code", code);// phone	String	必填	手机号码
        return params;
    }
    //获取商品列表
    public static HashMap<String, Object> getGoodsList(int type, int page,int limit) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("type", type);//1 推荐 2新品 3热销
        params.put("page", page);//
        params.put("limit", limit);//
        return params;
    }

   //获取商品详情
   public static HashMap<String, Object> getGoodsDetail(String  id) {
       HashMap<String, Object> params = new HashMap<>();
       params.put("id", id);//产品id
       return params;
   }




}

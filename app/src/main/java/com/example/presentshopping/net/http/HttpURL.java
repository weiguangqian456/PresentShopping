package com.example.presentshopping.net.http;


import com.example.presentshopping.BuildConfig;

import rxhttp.wrapper.annotation.DefaultDomain;
import rxhttp.wrapper.annotation.Domain;

/**
 * 请求接口。
 */
public class HttpURL {

    /**
     * RxHttp提供了@DefaultDomain()、@Domain()这两个注解来标明默认域名和非默认域名。
     * 通过@Domain()注解标注非默认域名，就会在RxHttp类中生成setDomainToXxxIfAbsent()方法，其中Xxx就是注解中取的别名。
     * 使用了注解，此时(需要Rebuild一下项目)就会在RxHttp类中生成相应的setDomainToXxxIfAbsent()方法。
     * RxHttp共有3种指定域名的方式，按优先级排名分别是：手动输入域名 > 指定非默认域名 > 使用默认域名。
     * 动态域名切换的需求，只需要对BaseUrl重新赋值即可，如下：
     * HttpURL.baseUrl = "https://www.qq.com";（动态更改默认域名，改完立即生效，非默认域获取用户等级名同理）。
     */
    @DefaultDomain // 设置为默认域名（唯一）
    public static String baseUrl = BuildConfig.BASE_Url;// "https://www.wanandroid.com/";



    @Domain(name = "BaseUrlBaidu") // 非默认域名，并取别名为BaseUrlBaidu ---（非默认域名 示例）。

    //加油站列表
    public final static String CheZhuBangControll = "/benefit/web/CheZhuBangController/queryGasStationInfoList";


    // 流量卡的 baseUrl
    public final static String Base_flowCardIp = "http://99.liumall.co/inter/";



}

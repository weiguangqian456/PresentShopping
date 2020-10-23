package com.example.presentshopping.net.manager;

import android.app.Application;
import android.util.Log;


import com.example.presentshopping.BuildConfig;
import com.example.presentshopping.config.base.MyApplication;
import com.example.presentshopping.config.constant.Constant;
import com.example.presentshopping.net.http.HttpURL;
import com.example.presentshopping.utils.sign.EncodeUtils;
import com.example.presentshopping.utils.tool.IntentJumpUtils;
import com.example.presentshopping.utils.tool.LogUtils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import rxhttp.wrapper.annotation.Converter;
import rxhttp.wrapper.callback.IConverter;
import rxhttp.wrapper.converter.FastJsonConverter;
import rxhttp.wrapper.converter.XmlConverter;
import rxhttp.wrapper.cookie.CookieStore;
import rxhttp.wrapper.param.Method;
import rxhttp.wrapper.param.RxHttp;
import rxhttp.wrapper.ssl.SSLSocketFactoryImpl;
import rxhttp.wrapper.ssl.X509TrustManagerImpl;

/**
 * User: ljx
 * Date: 2019-11-26
 * Time: 20:44
 */
public class RxHttpManager {

    @Converter(name = "FastJsonConverter")
    public static IConverter fastJsonConverter = FastJsonConverter.create();
    @Converter(name = "XmlConverter")
    public static IConverter xmlConverter = XmlConverter.create();

    // 设置连接超时时间
    private static final int CONNEC_TIMEOUT = 15;//15秒
    // 设置写入超时时间
    private static final int WRITE_TIMEOUT = 30 * 60;//30分钟
    // 设置读取超时时间
    private static final int READ_TIMEOUT = WRITE_TIMEOUT + 15;//30.25分钟
    // 设置总超时时间（总超时时间要小于全局读、写、连接超时时间之和，否则无效）
    public static final int TOTAL_TIMEOUT = CONNEC_TIMEOUT + 20 + 20;//55秒
    // 设置缓存大小200Mb
    private static final int CACHE_SIZE = 200 * 1024 * 1024;

    // RxHttp初始化
    public static void init(Application context) {
        File file = new File(context.getExternalCacheDir(), "RxHttpCookie");
        X509TrustManager trustAllCert = new X509TrustManagerImpl();
        SSLSocketFactory sslSocketFactory = new SSLSocketFactoryImpl(trustAllCert);
        /** OkHttp 3.0 的配置 */
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(CONNEC_TIMEOUT, TimeUnit.SECONDS)// 设置连接超时时间
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)// 设置读取超时时间
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)// 设置写入超时时间
                .retryOnConnectionFailure(true) // 方法为设置出现错误进行重新连接。
                .connectionPool(new ConnectionPool())
                .sslSocketFactory(sslSocketFactory, trustAllCert) // 添加信任证书
                .hostnameVerifier((hostname, session) -> true) // 忽略host验证
                // 下面三个方法为解决：302重定向问题。
                .followRedirects(false) // 禁制OkHttp的重定向操作，我们自己处理重定向
                .followSslRedirects(false)
                .cookieJar(new CookieStore(file))// 为OkHttp设置自动携带Cookie的功能；
                //.addInterceptor(getHeaderInterceptor())// 重新设置Header（上传文件这里有问题）
                // 设置日志拦截器
                .addInterceptor(getInterceptor())
                .cache(cache) // 缓存
                //.addInterceptor(new RedirectInterceptor())// 拦截器
                //.addInterceptor(new TokenInterceptor())// 拦截器
                .build();
        // RxHttp初始化，自定义OkHttpClient对象，非必须
        RxHttp.init(client, BuildConfig.DEBUG);

        //设置缓存策略，非必须
        //        File file = new File(context.getExternalCacheDir(), "RxHttpCache");
        //        RxHttpPlugins.setCache(file, 1000 * 100, CacheMode.REQUEST_NETWORK_FAILED_READ_CACHE);
        //        RxHttpPlugins.setExcludeCacheKeys("time"); //设置一些key，不参与cacheKey的组拼

        //设置数据解密/解码器，非必须
        //        RxHttp.setResultDecoder(s -> s);

        //设置全局的转换器，非必须
        //        RxHttp.setConverter(FastJsonConverter.create());

        //设置公共参数/请求头，非必须
        RxHttp.setOnParamAssembly(p -> {
            /**
             * 此方法在子线程中执行，即请求发起线程，根据不同请求类型添加不同参数，每次发送请求前都会被回调，
             * 如果希望部分请求不回调这里，发请求前调用Param.setAssemblyEnabled(false)即可。
             */
            Method method = p.getMethod();
            if (method.isGet()) { //Get请求
                if (p.getSimpleUrl().startsWith(HttpURL.Base_flowCardIp)) {
                    return p.addHeader("token", "")//添加公共请求头  getToken("cardlist")
                            .addHeader("accept", "*/*"); //添加公共请求头
                }
            } else if (method.isPost()) { //Post请求
            }
            //可以通过 p.getSimpleUrl() 拿到url更改后，重新设置
            //p.setUrl("");
            String token = IntentJumpUtils.getUsrToken();
            LogUtils.p("token: ", token);
            return p.addHeader("token", token)//添加公共请求头  .add("time", System.currentTimeMillis())//添加公共参数
                    .addHeader("accept", "*/*"); //添加公共请求头
        });
    }

    private static String getToken(String parm) {
        String pMd5 = EncodeUtils.MD5("0000000");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());

        String resultStr = "admin9962" + pMd5 + parm + simpleDateFormat.format(date);
        Log.e("CharQuerActivi", resultStr + "====" + EncodeUtils.getSHA256StrJava(resultStr));
        return EncodeUtils.getSHA256StrJava(resultStr);
    }

    // 缓存
    private static Cache cache = new Cache(new File(MyApplication.getContext().getCacheDir(), "cache"), CACHE_SIZE); // 200Mb

    /**
     * 302重定向问题：重新设置Header、okHttp的cookie操作请求。
     * @return
     */
    private static Interceptor getHeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                // String url = original.url().toString();
                /**
                 * 如果不用CookieJar,那么就要自己去解析返回的Set-Cookie字段,解析之后通过addHeader("Cookie", cookie)
                 * 添加Cookie请求头
                 */
                List<String> cookies =  original.headers("Set-Cookie");
                String cookie = "";
                for (int i = cookies.size() - 1; i >= 0; i--) {
                    cookie = cookie + cookies.get(i).replace("path=/", "") + " ";
                }
                // cookie = original.header("Set-Cookie");
                // 添加公共参数
                Request.Builder requestBuilder;
                if (StringUtils.isNotEmpty(cookie)) {
                    // 添加公共参数
                    requestBuilder = original.newBuilder()
                            .header("cookie", cookie)
                            .header("token", IntentJumpUtils.getUsrToken())//重新添加Token
                            .header("accept", "*/*"); //添加公共请求头
                } else {
                    // 添加公共参数
                    requestBuilder = original.newBuilder()
                            .header("token", IntentJumpUtils.getUsrToken())//重新添加Token
                            .header("accept", "*/*"); //添加公共请求头
                }
                Request request = requestBuilder.build();
                // 返回新的请求。
                return chain.proceed(request);
            }
        };
    }

    /**
     * 日志拦截器
     */
    private static Interceptor getInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //RxJava2 取消订阅后，抛出的异常无法捕获，导致程序崩溃
                RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // 显示日志
                        LogUtils.w(Constant.LOGGER, message);
                    }
                });
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);// 设置打印数据的级别
    }

}

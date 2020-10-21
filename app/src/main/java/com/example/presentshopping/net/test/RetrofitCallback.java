package com.example.presentshopping.net.test;

import android.text.TextUtils;


import com.example.presentshopping.config.base.Const;
import com.example.presentshopping.config.bean.ResultEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author : hc
 * @date : 2019/4/9.
 * @description:
 */

public abstract class RetrofitCallback<T extends ResultEntity> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        String msg = "数据或网络异常";
        T body = response.body();
        if(body != null){
            if(body.getCode() == Const.REQUEST_CODE){
                if(body.getData() != null){
                    onNext(response.body());
                }
                onFinish();
                return;
            }else{
                msg = TextUtils.isEmpty(body.getMsg()) ? msg : body.getMsg();
            }
        }

        onFinish();
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFinish();
    }

    protected abstract void onNext(T result);

    protected void onFinish(){

    }
}

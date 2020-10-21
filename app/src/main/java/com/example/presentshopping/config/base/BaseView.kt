package com.example.presentshopping.config.base

import android.content.Context
import com.uber.autodispose.AutoDisposeConverter

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
interface BaseView {
    /**
     * @param msg 显示提示
     */
    fun showToast(msg: String?)

    /**
     * 获取上下文
     * @return 上下文
     */
    val context: Context?

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
    </T> */
    fun <T> bindAutoDispose(): AutoDisposeConverter<T>?
}
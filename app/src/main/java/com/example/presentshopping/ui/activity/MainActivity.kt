package com.example.presentshopping.ui.activity

import android.os.Bundle
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity
import com.example.presentshopping.utils.edit.StatusBarUtil
import com.example.presentshopping.utils.tool.SoftHideKeyBoardUtil

class MainActivity : BaseMvpActivity() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        /**
         * 设置状态栏透明：侵入式透明status bar >> 顶部需要沉浸的是图片View.
         * 不要忘记了, 在当前activity onCreate中设置 取消padding,  因为这个padding 我们用代码实现了,不需要系统帮我
         */
        StatusBarUtil.setRootViewFitsSystemWindows(this, false)
        SoftHideKeyBoardUtil.assistActivity(this)


    }

    override fun showToast(msg: String?) {

    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }
}
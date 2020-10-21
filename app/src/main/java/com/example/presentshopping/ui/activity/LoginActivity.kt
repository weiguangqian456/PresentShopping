package com.example.presentshopping.ui.activity

import android.os.Bundle
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity
import com.example.presentshopping.utils.glide.GlideUtil

class LoginActivity : BaseMvpActivity() {
    override val layoutId: Int
        get() = R.layout.login_activity

    override fun initView(savedInstanceState: Bundle?) {



    }

    override fun showToast(msg: String?) {

    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }

}
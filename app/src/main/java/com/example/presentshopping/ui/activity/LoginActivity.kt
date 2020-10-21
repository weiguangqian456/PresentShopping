package com.example.presentshopping.ui.activity

import android.os.Bundle
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity

class LoginActivity : BaseMvpActivity() {
    override val layoutId: Int
        get() = R.layout.login_activity

    override fun initView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun showToast(msg: String?) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(data: String?) {
        TODO("Not yet implemented")
    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {
        TODO("Not yet implemented")
    }

}
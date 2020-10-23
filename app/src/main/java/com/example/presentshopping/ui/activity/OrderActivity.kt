package com.example.presentshopping.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity

class OrderActivity :BaseMvpActivity() {

    override val layoutId: Int
        get() = R.layout.activity_order

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun showToast(msg: String?) {

    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }
}
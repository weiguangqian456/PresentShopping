package com.example.presentshopping.ui.fragment.special

import android.os.Bundle
import android.view.View
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpFragment

class PaymentFragment :BaseMvpFragment() {

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }

    override val layoutId: Int
        get() = R.layout.payment_fragment
}
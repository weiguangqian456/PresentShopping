package com.example.presentshopping.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseFragment
import com.example.presentshopping.config.base.BaseMvpFragment

class ClientFragment :  BaseMvpFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_client

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun onSuccess(data: String?) {
        TODO("Not yet implemented")
    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {
        TODO("Not yet implemented")
    }
}
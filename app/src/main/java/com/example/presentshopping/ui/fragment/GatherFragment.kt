package com.example.presentshopping.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseFragment
import com.example.presentshopping.config.base.BaseMvpFragment
import com.example.presentshopping.mvp.presenter.PublicPresenter


class GatherFragment : BaseMvpFragment() {
    private var queryInfoPresenter: PublicPresenter? = null
    override val layoutId: Int
        get() = R.layout.fragment_gather

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        queryInfoPresenter = PublicPresenter(context, false, "")
        queryInfoPresenter?.attachView(this)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        queryInfoPresenter?.detachView()
    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }


}
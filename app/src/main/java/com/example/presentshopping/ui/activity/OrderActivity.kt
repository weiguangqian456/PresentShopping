package com.example.presentshopping.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity
import com.example.presentshopping.ui.fragment.GeneralFragment
import com.example.presentshopping.ui.fragment.SpecialFragment
import kotlinx.android.synthetic.main.activity_order.*
import java.util.*

class OrderActivity : BaseMvpActivity() {

    private val strTitle = arrayOf("普通订单", "拼团订单")

    override val layoutId: Int
        get() = R.layout.activity_order

    override fun initView(savedInstanceState: Bundle?) {
        title_main_tv.leftBackImageTv.setOnClickListener { finish() }
        val pageViews = ArrayList<Fragment>()
        // 添加顺序必须与标题 strTitle 一一对应。
        pageViews.add(GeneralFragment())
        pageViews.add(SpecialFragment())
        tab_layout?.setViewPager(viewPager, strTitle, this, pageViews)  
    }

    override fun showToast(msg: String?) {

    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }


}
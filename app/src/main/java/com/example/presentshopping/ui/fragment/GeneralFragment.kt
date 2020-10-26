package com.example.presentshopping.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpFragment
import com.example.presentshopping.ui.fragment.special.PaymentFragment
import com.flyco.tablayout.SlidingTabLayout


//普通订单
class GeneralFragment :BaseMvpFragment(){
    private val strTitle = arrayOf("全部","未支付" ,"待发货", "待收货" ,"已完成")

    var  GeneralViewPager : ViewPager?=null
    override val layoutId: Int
        get() = R.layout.gener_frament

    override fun initView(view: View?, savedInstanceState: Bundle?) {

        val pageViews = ArrayList<Fragment>()
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        GeneralViewPager = view?.findViewById(R.id.GeneralViewPager)
        view?.findViewById<SlidingTabLayout>(R.id.tablayout)?.setViewPager(GeneralViewPager, strTitle, activity, pageViews)


    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }


}
package com.example.presentshopping.ui.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity
import com.example.presentshopping.ui.fragment.GeneralFragment
import com.example.presentshopping.ui.fragment.SpecialFragment
import kotlinx.android.synthetic.main.activity_order.*
import java.util.*

class OrderActivity : BaseMvpActivity() {



    private val fragments = ArrayList<Fragment>() //一个持有者，用来存放被实例化的fragment
    var currentPage = 0 //当前页


    override val layoutId: Int
        get() = R.layout.activity_order

    override fun initView(savedInstanceState: Bundle?) {
        title_main_tv.leftBackImageTv.setOnClickListener { finish() }
        fragments.add(SpecialFragment())
        fragments.add(GeneralFragment())
        content_vp.adapter = adapter
        content_vp.offscreenPageLimit = adapter.count

        SpecialOrder.setOnClickListener {
            CommonOrder.setTextColor(getColor(R.color.colorBlack))
            SpecialOrder.setTextColor(getColor(R.color.purple_200))
            currentPage = 0
            switchPage()
        }

        CommonOrder.setOnClickListener {
            CommonOrder.setTextColor(getColor(R.color.purple_200))
            SpecialOrder.setTextColor(getColor(R.color.colorBlack))
            currentPage = 1
            switchPage()

        }

    }


    //初始化视图
    private fun switchPage() {

        //首页单击事件处理（针对界面的）
        if (currentPage == 0) {
            content_vp.setCurrentItem(0, false) //如果ViewPager中页面太多就会出问题，不过这里的ViewPager设置了不允许侧滑，应该没啥事
        } else if (currentPage == 1) {
            content_vp.setCurrentItem(1, false)
        }
    }

    override fun showToast(msg: String?) {

    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }

    /**
     * viewpager适配器
     */
    private val adapter: PagerAdapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }
    }


}
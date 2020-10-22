package com.example.presentshopping.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity
import com.example.presentshopping.ui.fragment.BoardFragment
import com.example.presentshopping.ui.fragment.ClientFragment
import com.example.presentshopping.ui.fragment.GatherFragment
import com.example.presentshopping.ui.fragment.MyFragment
import com.example.presentshopping.utils.edit.StatusBarUtil
import com.example.presentshopping.utils.tool.SoftHideKeyBoardUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvpActivity() {

    private val showFragmentPage = -1
    private var fragmentTransaction: FragmentTransaction? = null
    private var TabFragment1: Fragment? = null
    private var TabFragment2: Fragment? = null
    private var TabFragment3: Fragment? = null
    private var TabFragment4: Fragment? = null


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


    companion object {
        // 跳转到当前页面。
        fun toStartActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent)
        }
    }

    override fun showToast(msg: String?) {

    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }

    fun initFramgment() {
        // 初始化Fragment。

        // 初始化Fragment。
        TabFragment1 = GatherFragment()
        TabFragment2 = BoardFragment()
        TabFragment3 = ClientFragment()
        TabFragment4 = MyFragment()
    }


    fun switchFragment(page: Int) {
        if (page == showFragmentPage) {
            return
        }
        fragmentTransaction = supportFragmentManager.beginTransaction()
        resetBtn()


    }

    fun resetBtn() {

        ivTab1.setImageResource(R.mipmap.shouye1)
        tvTab1.setTextColor(resources.getColor(R.color.colorLineBox))

        iv_Tab2.setImageResource(R.mipmap.gouwuche1)
        tv_Tab2.setTextColor(resources.getColor(R.color.colorLineBox))

        iv_Tab3.setImageResource(R.mipmap.fenlei1)
        tv_Tab3.setTextColor(resources.getColor(R.color.colorLineBox))

        iv_Tab4.setImageResource(R.mipmap.gerenzhongxin1)
        tv_Tab4.setTextColor(resources.getColor(R.color.colorLineBox))


    }

}
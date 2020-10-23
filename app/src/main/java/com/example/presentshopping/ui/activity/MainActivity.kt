package com.example.presentshopping.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity
import com.example.presentshopping.config.event.MainFragmentEvent
import com.example.presentshopping.ui.fragment.BoardFragment
import com.example.presentshopping.ui.fragment.ClientFragment
import com.example.presentshopping.ui.fragment.GatherFragment
import com.example.presentshopping.ui.fragment.MyFragment
import com.example.presentshopping.utils.edit.StatusBarUtil
import com.example.presentshopping.utils.tool.IntentJumpUtils
import com.example.presentshopping.utils.tool.SoftHideKeyBoardUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus

class MainActivity : BaseMvpActivity() {

    private var showFragmentPage = -1
    private var fragmentTransaction: FragmentTransaction? = null
    private lateinit var TabFragment1: Fragment
    private lateinit var TabFragment2: Fragment
    private lateinit var TabFragment3: Fragment
    private lateinit var TabFragment4: Fragment


    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        /**
         * 设置状态栏透明：侵入式透明status bar >> 顶部需要沉浸的是图片View.
         * 不要忘记了, 在当前activity onCreate中设置 取消padding,  因为这个padding 我们用代码实现了,不需要系统帮我
         */
        StatusBarUtil.setRootViewFitsSystemWindows(this, false)
        SoftHideKeyBoardUtil.assistActivity(this)
        initFramgment()

        ly_Tab1.setOnClickListener {                   // 加载Fragment
            switchFragment(0)
        }
        ly_Tab2.setOnClickListener {                      // 加载Fragment
            switchFragment(1)
        }
        ly_Tab3.setOnClickListener {                      // 加载Fragment
            switchFragment(2)
        }
        ly_Tab4.setOnClickListener {
            if (IntentJumpUtils.isLogin()) {
                // 跳转首页
                switchFragment(3)
            } else {
                // 登录
                IntentJumpUtils.goToLogin(this@MainActivity, "")
            }
            // 加载Fragment

        }


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
        TabFragment1 = GatherFragment()
        TabFragment2 = BoardFragment()
        TabFragment3 = ClientFragment()
        TabFragment4 = MyFragment()
        /**
         * getFragmentManager();注：如果使用Android3.0以下的版本，需要引入v4的包，
         * 然后Activity继承FragmentActivity，然后通过getSupportFragmentManager获得FragmentManager。
         */
        // 开启一个Fragment事务
        fragmentTransaction = supportFragmentManager.beginTransaction()

        // 如果MessageFragment为空，则创建一个并添加到界面上
        fragmentTransaction!!.add(R.id.id_content, TabFragment1 as GatherFragment)
        fragmentTransaction!!.add(R.id.id_content, TabFragment2 as BoardFragment)
        fragmentTransaction!!.add(R.id.id_content, TabFragment3 as ClientFragment)
        fragmentTransaction!!.add(R.id.id_content, TabFragment4 as MyFragment)
        // 重置按钮
        resetBtn()
        // 加载Fragment
        fragmentTransaction!!.commit()


        // 页面判断（初始化加载页面）
        switchFragment(0)
    }

    // 加载Fragment
    fun switchFragment(page: Int) {
        if (page == showFragmentPage) {
            return
        }
        fragmentTransaction = supportFragmentManager.beginTransaction()
        resetBtn()
        // 页面判断
        when (page) {
            0 -> {
                ivTab1.setImageResource(R.mipmap.shouye)
                tvTab1.setTextColor(resources.getColor(R.color.colorMain))
                // 设置要显示的Fragment
                fragmentTransaction!!.show(TabFragment1!!)
            }
            1 -> {
                iv_Tab2.setImageResource(R.mipmap.gouwuche)
                tv_Tab2.setTextColor(resources.getColor(R.color.colorMain))
                // 设置要显示的Fragment
                fragmentTransaction!!.show(TabFragment2!!)
            }
            2 -> {
                iv_Tab3.setImageResource(R.mipmap.fenlei)
                tv_Tab3.setTextColor(resources.getColor(R.color.colorMain))
                // 设置要显示的Fragment
                fragmentTransaction!!.show(TabFragment3!!)
            }
            3 -> {
                iv_Tab4.setImageResource(R.mipmap.gerenzhongxin)
                tv_Tab4.setTextColor(resources.getColor(R.color.colorMain))
                // 设置要显示的Fragment
                fragmentTransaction!!.show(TabFragment4!!)
            }
        }

        // 发送到Fragment页面刷新数据
        EventBus.getDefault().post(MainFragmentEvent(page))

        // 加载Fragment
        // 加载Fragment
        fragmentTransaction!!.commit()
        showFragmentPage = page

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

        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        fragmentTransaction!!.hide(TabFragment1)
        fragmentTransaction!!.hide(TabFragment2)
        fragmentTransaction!!.hide(TabFragment3)
        fragmentTransaction!!.hide(TabFragment4)

    }

}
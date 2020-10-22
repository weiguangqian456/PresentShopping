package com.example.presentshopping.ui.activity

import android.os.Bundle
import android.os.CountDownTimer
import android.view.KeyEvent
import com.blankj.utilcode.util.AppUtils
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity
import com.example.presentshopping.config.constant.Constant
import com.example.presentshopping.utils.tool.IntentJumpUtils
import com.example.presentshopping.utils.tool.SharePrefrencesUtil
import kotlin.system.exitProcess

class WelcomeActivity : BaseMvpActivity() {


    // 引导页打开判断（默认不要打开）
    private var guidePage_bool = true

    override val layoutId: Int
        get() = R.layout.activity_welcome

    override fun initView(savedInstanceState: Bundle?) {
        guidePage_bool = true

        /**  跳转首页。  */
        /**  跳转首页。   */
        welcomeToHome(guidePage_bool, 500, 1000) // 延迟1000ms时间


    }

    override fun showToast(msg: String?) {

    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }

    /**
     * 跳转首页。
     */
    fun welcomeToHome(bool: Boolean, millisInFuture: Long, countDownInterval: Long) {
        if (bool) {
            // 延时进入下一级页面。
            startTimer(millisInFuture, countDownInterval) // 延迟1000ms时间
        }
    }

    private fun startTimer(millisInFuture: Long, countDownInterval: Long) {
        object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                //Log.d("tag",millisUntilFinished+"");
            }

            override fun onFinish() {
                if (guidePage_bool) {
                    // 缓存该次的引导页标示（以版本号为标示）。
                    SharePrefrencesUtil.put(Constant.GuidePage, AppUtils.getAppVersionName())
                    // 跳转更新。
                    runOnUiThread { // 登录判断。

                        MainActivity.toStartActivity(this@WelcomeActivity)

//
//                        if (IntentJumpUtils.isLogin()) {
//                            // 跳转首页
//
//                        } else {
//                            // 登录
//                            IntentJumpUtils.goToLogin(this@WelcomeActivity, "")
//                        }
                        guidePage_bool = false
                        finish()
                    }
                }
            }
        }.start()
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {
            // ActivityPool.exitApp();
            // finishSelf();
            exitProcess(0)
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
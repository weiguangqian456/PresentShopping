package com.example.presentshopping.ui.activity

import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpActivity
import com.example.presentshopping.mvp.presenter.PublicPresenter
import com.example.presentshopping.net.http.HttpRequest
import com.example.presentshopping.net.http.HttpURL
import com.example.presentshopping.net.observer.TaskCallback
import com.example.presentshopping.utils.ToastUtil
import com.example.presentshopping.utils.tool.IntentJumpUtils
import com.example.presentshopping.utils.tool.IntentJumpUtils.LoginSucceeded
import com.example.presentshopping.utils.tool.LogUtils
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : BaseMvpActivity() {

    private var countdown = 0
    private var sendMesPresenter: PublicPresenter? = null
    private var mobile: String? = null
    private var code: String? = null

    override val layoutId: Int
        get() = R.layout.login_activity

    override fun initView(savedInstanceState: Bundle?) {
        sendMesPresenter = PublicPresenter(context, false, "")
        sendMesPresenter?.attachView(this)
        tv_getSMSCode.setOnClickListener { sendMes() }
        tv_login.setOnClickListener { senlogin() }

    }

    override fun onDestroy() {
        sendMesPresenter?.detachView()
        super.onDestroy()
    }

    override fun showToast(msg: String?) {
        ToastUtil.showMsg(msg)
    }

    override fun onSuccess(data: String?) {
        LogUtils.p("onSuccess---->", data)
        IntentJumpUtils.LoginSucceeded(
            context, data, resources.getString(R.string.loginSucceeded),
            resources.getString(R.string.LoginFailed)
        )
    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {
        showToast(msg)
    }

    // 验证码倒计时。
    private fun startTimer() {
        countdown = 60
        //tv_Sent_SMS.setTextColor(getResources().getColor(R.color.colorMain));
        tv_getSMSCode.isClickable = false
        object : CountDownTimer(1000 * 60, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                try {
                    if (countdown != -1) {
                        countdown--
                        tv_getSMSCode.text = countdown.toString() + "s"
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFinish() {
                try {
                    //tv_Sent_SMS.setTextColor(getResources().getColor(R.color.colorMain));
                    tv_getSMSCode.text = resources.getString(R.string.ToResend)
                    tv_getSMSCode.isClickable = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    /**
     * 发送短信
     */
    private fun sendMes() {
        mobile = et_phone.text.toString().trim { it <= ' ' }
        if (TextUtils.isEmpty(mobile)) {
            showToast(resources.getString(R.string.AccountCannotEmpty))
            return
        }
        LogUtils.p("sendMes", mobile)
        LogUtils.p("sendMes", HttpURL.Req_sendSms)
        // 获取短信
        sendMesPresenter?.netWorkRequestPost(HttpURL.Req_sendSms,
            HttpRequest.SendSms(mobile), object : TaskCallback {
                override fun onSuccess(data: String?) {
                    // 验证码已发送
                    showToast(resources.getString(R.string.TheVerificationCodeSent))
                    // 验证码倒计时。
                    startTimer()
                }

                override fun onFailure(
                    e: Throwable?,
                    code: Int,
                    msg: String?,
                    isNetWorkError: Boolean
                ) {
                    showToast(msg)
                }
            })
    }

    //登录
    private fun senlogin() {
        mobile = et_phone.text.toString().trim { it <= ' ' }
        code = et_SMSCode.text.toString().trim { it <= ' ' }

        if (TextUtils.isEmpty(mobile)) {
            showToast(resources.getString(R.string.AccountCannotEmpty))
            return
        }
        if (TextUtils.isEmpty(code)) {
            showToast(resources.getString(R.string.voe_name))
            return
        }
        LogUtils.p("senlogin", HttpURL.Req_login)

        sendMesPresenter?.netWorkRequestPost(HttpURL.Req_login, HttpRequest.Sendlogin(mobile, code))
    }

}
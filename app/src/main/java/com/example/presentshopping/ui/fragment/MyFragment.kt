package com.example.presentshopping.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseFragment
import com.example.presentshopping.config.base.BaseMvpFragment
import com.example.presentshopping.config.bean.UserInfoBean
import com.example.presentshopping.mvp.presenter.PublicPresenter
import com.example.presentshopping.net.http.HttpRequest
import com.example.presentshopping.net.http.HttpURL
import com.example.presentshopping.net.observer.TaskCallback
import com.example.presentshopping.ui.activity.*
import com.example.presentshopping.utils.tool.GsonUtils
import com.example.presentshopping.utils.tool.IntentJumpUtils.goToLogin
import com.example.presentshopping.utils.tool.IntentJumpUtils.startIntent
import com.example.presentshopping.utils.tool.LogUtils
import kotlinx.android.synthetic.main.fragment_my.*
import rxhttp.wrapper.utils.LogUtil
//个人中心
class MyFragment : BaseMvpFragment() {

    private var queryInfoPresenter: PublicPresenter? = null
    var userInforBean: UserInfoBean? = null

    override val layoutId: Int
        get() = R.layout.fragment_my

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        queryInfoPresenter = PublicPresenter(context, false, "")
        queryInfoPresenter?.attachView(this)
        oneMyINt()

        view?.findViewById<LinearLayout>(R.id.iv_share0)?.setOnClickListener { startIntent(context, OrderActivity().javaClass) }

        view?.findViewById<LinearLayout>(R.id.iv_share1)?.setOnClickListener { startIntent(context, RqCodeActivity().javaClass) }

        view?.findViewById<LinearLayout>(R.id.iv_share2)?.setOnClickListener { startIntent(context, TeamActivity().javaClass) }

        view?.findViewById<LinearLayout>(R.id.iv_share3)?.setOnClickListener { startIntent(context, SpreadActivity().javaClass) }

        view?.findViewById<LinearLayout>(R.id.iv_share)?.setOnClickListener { startIntent(context, WalletActivity().javaClass) }

        view?.findViewById<LinearLayout>(R.id.iv_share6)?.setOnClickListener { startIntent(context, LocationActivity().javaClass) }


    }

    fun oneMyINt() {
        Log.e("MyFragment", HttpURL.Req_getUserInfo)
        queryInfoPresenter?.netWorkRequestPost(
            HttpURL.Req_getUserInfo,
            HttpRequest.getGoodsList(1, 1, 1), object : TaskCallback {
                override fun onSuccess(data: String?) {
                    data?.let { Log.e("MyFragment", it) }
                    userInforBean = GsonUtils.getGson().fromJson(data, UserInfoBean().javaClass)
                    vs_myselft_account.text = userInforBean?.data?.mobile
                    balance_textview_01.text = userInforBean?.data?.balance
                    balance_textview_05.text = userInforBean?.data?.points.toString()

                }

                override fun onFailure(
                    e: Throwable?,
                    code: Int,
                    msg: String?,
                    isNetWorkError: Boolean
                ) {

                }
            }
        )
    }

    override fun onSuccess(data: String?) {

    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }


    override fun onDestroyView() {
        queryInfoPresenter?.detachView()
        super.onDestroyView()
    }

}
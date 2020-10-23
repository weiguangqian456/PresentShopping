package com.example.presentshopping.ui.fragment

import BaseRecyclerAdapter
import BaseRecyclerHolder
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigkoo.convenientbanner.ConvenientBanner
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpFragment
import com.example.presentshopping.config.bean.IamgeViewBean
import com.example.presentshopping.config.bean.SupplierListBean
import com.example.presentshopping.mvp.presenter.PublicPresenter
import com.example.presentshopping.net.http.HttpRequest
import com.example.presentshopping.net.http.HttpURL
import com.example.presentshopping.net.observer.TaskCallback
import com.example.presentshopping.utils.tool.GsonUtils
import com.example.presentshopping.utils.tool.IntentJumpUtils
import com.example.presentshopping.utils.tool.LogUtils
import com.yanzhenjie.recyclerview.SwipeRecyclerView
import kotlinx.android.synthetic.main.fragment_client_head_view.*
import kotlinx.android.synthetic.main.fragment_gather.*


class GatherFragment : BaseMvpFragment() {

    var baseRecyclerAdapter: BaseRecyclerAdapter<SupplierListBean.DataBean.ListBean>? = null
    var headerView: View? = null
    var cb_banner: ConvenientBanner<IamgeViewBean>? = null

    lateinit var recycler_view: SwipeRecyclerView
    private var queryInfoPresenter: PublicPresenter? = null
    override val layoutId: Int
        get() = R.layout.fragment_gather

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        queryInfoPresenter = PublicPresenter(context, false, "")
        queryInfoPresenter?.attachView(this)
        RgetGoodsList()
        recycler_view = view?.findViewById(R.id.recycler_view)!!
        // 客户数据View
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.useDefaultLoadMore()
        headerView = layoutInflater.inflate(R.layout.fragment_client_head_view, recycler_view, false)
        recycler_view.addHeaderView(headerView)
        cb_banner = headerView?.findViewById<ConvenientBanner<IamgeViewBean>>(R.id.cbanner_img)
        getlabem()
        setBaseAdapter()
    }


    //商品列表
    fun setBaseAdapter() {
        baseRecyclerAdapter = object : BaseRecyclerAdapter<SupplierListBean.DataBean.ListBean>(
            context,
            null,
            R.layout.item_more_refuel
        ) {
            override fun convert(
                holder: BaseRecyclerHolder?,
                data: SupplierListBean.DataBean.ListBean,
                position: Int,
                isScrolling: Boolean,
                selectedPosition: Int
            ) {


            }
        }
        recycler_view.adapter = baseRecyclerAdapter


    }

    //
    fun setBaseIamgview() {


    }


    override fun onDestroyView() {
        super.onDestroyView()
        queryInfoPresenter?.detachView()
    }

    override fun onSuccess(data: String?) {
    }

    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }

    //轮播图
    fun getlabem() {
        queryInfoPresenter?.netWorkRequestPost(
            HttpURL.Req_ggetCarousel,
            HttpRequest.getGoodsList(1, 1, 10),
            object : TaskCallback {
                override fun onSuccess(data: String?) {
                    LogUtils.p("onSuccess-----", data)
                    val beanbr = GsonUtils.getGson().fromJson(data, IamgeViewBean().javaClass)
                    if (beanbr.data?.list!!.isEmpty()) {
                    } else {
                        cb_banner?.setPageIndicator(
                            intArrayOf(
                                R.mipmap.xiang_huise,
                                R.mipmap.xing_bai
                            )
                        )
                        cb_banner?.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                        IntentJumpUtils.setPase(cb_banner, beanbr?.data?.list as List<Any>?)
                        cb_banner?.startTurning(3000)
                    }


                }

                override fun onFailure(
                    e: Throwable?,
                    code: Int,
                    msg: String?,
                    isNetWorkError: Boolean
                ) {


                }

            })
    }

    //获取商品列表
    fun RgetGoodsList() {
        queryInfoPresenter?.netWorkRequestPost(
            HttpURL.Req_getGoodsList,
            HttpRequest.getGoodsList(1, 1, 10),
            object : TaskCallback {
                override fun onSuccess(data: String?) {
                    LogUtils.p("onSuccess-----", data)
                }

                override fun onFailure(
                    e: Throwable?,
                    code: Int,
                    msg: String?,
                    isNetWorkError: Boolean
                ) {
                    LogUtils.p("onFailure-----", msg)
                }
            })
    }


}
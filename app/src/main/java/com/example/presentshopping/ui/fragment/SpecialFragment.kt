package com.example.presentshopping.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.presentshopping.R
import com.example.presentshopping.config.base.BaseMvpFragment
import com.example.presentshopping.ui.fragment.special.PaymentFragment
import com.flyco.tablayout.SlidingTabLayout

//拼团订单
class SpecialFragment : BaseMvpFragment() {

    private val strTitle = arrayOf("全部","未支付" ,"待发货", "待收货", "已取消" ,"拼团成功", "拼团失败" ,"已完成")
//    var  page  = 1
//    var specialBean: SpecialOrderBean? = null
//    var refresh_layout: SwipeRefreshLayout? = null
//    var Special_recy: SwipeRecyclerView? = null
//    var baseRecyclerAdapter: BaseRecyclerAdapter<SpecialOrderBean.DataBean.ListBean>? = null
//    private var queryInfoPresenter: PublicPresenter? = null
   var SpecialViewPager : ViewPager ?=null
    override val layoutId: Int
        get() = R.layout.special_fragment

    override fun initView(view: View?, savedInstanceState: Bundle?) {
//        queryInfoPresenter = PublicPresenter(context, false, "")
//        queryInfoPresenter?.attachView(this)
//        if (view != null) {
//            iniview(view)
//        }
//        OrderList("")
//        setAdapter()
//        refresh_layout?.isRefreshing = true
//        refresh_layout?.setOnRefreshListener { OrderList("") }
//
//        Special_recy?.adapter = baseRecyclerAdapter

        val pageViews = ArrayList<Fragment>()
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        pageViews.add(PaymentFragment())
        SpecialViewPager =view?.findViewById(R.id.SpecialViewPager)
        view?.findViewById<SlidingTabLayout>(R.id.tablayout)?.setViewPager(SpecialViewPager, strTitle, activity, pageViews)
    }

//    fun iniview(view: View) {
//        refresh_layout = view.findViewById(R.id.refresh_layout)
//        Special_recy = view.findViewById(R.id.Special_recy)
//
//    }

    fun OrderList(status: String) {
//        page = 1
//        queryInfoPresenter?.netWorkRequestPost(
//
//            HttpURL.Req_getOrderList,
//            HttpRequest.getOrderList(5, status, page, 10)
//        )
    }
//
//    fun setAdapter() {
//        baseRecyclerAdapter = object : BaseRecyclerAdapter<SpecialOrderBean.DataBean.ListBean>(context, null, R.layout.iemt_special) {
//            @SuppressLint("SetTextI18n")
//            override fun convert(holder: BaseRecyclerHolder?, data: SpecialOrderBean.DataBean.ListBean, position: Int, isScrolling: Boolean, selectedPosition: Int) {
//                val time = holder?.getView<TextView>(R.id.time_tv)
//                val title = holder?.getView<TextView>(R.id.title_tv)
//                val amount = holder?.getView<TextView>(R.id.amount_tv)
//                val number = holder?.getView<TextView>(R.id.number_tv)
//                val thumb = holder?.getView<ImageView>(R.id.thumb_iv)
//                val statustv =holder?.getView<TextView>(R.id.status_tv)
//                val status = data?.status
//                val team_status =data?.team_status
//                time?.text = data.create_time
//                title?.text = data.title
//                amount?.text = " ￥" + data.amount
//                number?.text = "X" + data.number
//                GlideUtil.load(context, data?.thumb, thumb)
//                var tvstatus =""
//            when(team_status){
//                1 -> { tvstatus ="拼团中"}
//                2 ->{
//                 when(status){
//                     1->tvstatus ="未支付"
//                     2->tvstatus ="待发货 "
//                     3->tvstatus ="待收货"
//                     4->tvstatus ="已取消"
//                     5->tvstatus ="拼团成功"
//                     6->tvstatus ="拼团失败"
//                     7->tvstatus ="已完成"
//                 }
//                }
//            }
//                statustv?.text = tvstatus
//
//            }
//
//        }
//    }

    override fun onSuccess(data: String?) {

//        refresh_layout?.isRefreshing = false
//        specialBean = GsonUtils.getGson().fromJson(data, SpecialOrderBean().javaClass)
//        if(page==1){
//            baseRecyclerAdapter?.clear()
//        }
//        baseRecyclerAdapter?.setData(specialBean?.data?.list)
    }


    override fun onFailure(e: Throwable?, code: Int, msg: String?, isNetWorkError: Boolean) {

    }

    override fun onDestroyView() {
      //  queryInfoPresenter?.detachView()
        super.onDestroyView()
    }



}
package com.example.presentshopping.ui.adapter

import android.view.View
import android.widget.ImageView


import com.bigkoo.convenientbanner.holder.Holder
import com.bumptech.glide.Glide
import com.example.presentshopping.R
import com.example.presentshopping.config.base.Const
import com.example.presentshopping.config.base.MyApplication
import com.example.presentshopping.config.bean.IamgeViewBean


/**
 * @author Created by EDZ on
 * 商品详情中图片轮播适配器
 */
class HomePageBannerViewHolder(itemView: View) : Holder<IamgeViewBean.DataBean.ListBean>(itemView) {

    private var imageView: ImageView? = null

    override fun initView(itemView: View) {
        imageView = itemView.findViewById(R.id.sdv_item_head_img)
    }

    override fun updateUI(data: IamgeViewBean.DataBean.ListBean) {
        Glide.with(MyApplication.getContext()).load(data.img)
            .into(imageView!!)
        imageView?.setOnClickListener {  }

    }
}

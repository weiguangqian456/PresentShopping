package com.example.presentshopping.config.base

/**
 * @author Created by EDZ on 2018/6/5.
 * 基本配置信息
 */
interface Const {
    companion object {
        /**
         * 返回码
         */
        const val REQUEST_CODE = 0

        /**
         * 超时时间
         */
        const val HTTP_TIME = 30

        /**
         * 域名   正式
         */
        const val BASE_URL = "http://jy.edawtech.com/"

        /**
         * 相关模块
         */
        const val SHOP_MODEL = "/shop/api/"

        /**
         * 图片域名
         */
        const val BASE_IMAGE_URL = "http://qiniu.edawtech.com/"
    }
}
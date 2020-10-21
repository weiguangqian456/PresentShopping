package com.example.presentshopping.config.base

import android.app.Application
import android.content.Context
import android.os.Handler

class MyApplication : Application() {
    var payType = 0
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        val context: Context? = null
        private val mInstance: MyApplication? = null

        // 当前线程id
        var mainThreadId = 0
        var handler: Handler? = null
    }
}
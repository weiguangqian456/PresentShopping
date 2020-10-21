package com.example.presentshopping.config.base

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.Lifecycle
import com.example.presentshopping.mvp.contract.PublicContract
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.AutoDisposeConverter
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
abstract class BaseMvpActivity : BaseActivity(), BaseView, PublicContract.View {
    private var mContextMVP: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContextMVP = context
        // 开启广播
        /**
         * 小米政企服务系统权限控制。
         */
        //systemPermissionControl();
    }

    override val context: Context
        get() = this

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        // 注销广播。
        // 蓝牙广播
        application.unregisterReceiver(mBluetoothStateBroadcastReceiver)
        // 定位广播
    }

    /**
     * 绑定生命周期 防止MVP内存泄漏
     * @param <T>
     * @return
    </T> */
    override fun <T> bindAutoDispose(): AutoDisposeConverter<T>? {
        return AutoDispose.autoDisposable(
            AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY)
        ) // OnDestory时自动解绑
    }

    /**
     * Broadcast receiver to monitor the changes in the location provider.
     *
     * / **
     * Broadcast receiver to monitor the changes in the bluetooth adapter.
     */
    private val mBluetoothStateBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.STATE_OFF)
            val previousState = intent.getIntExtra(
                BluetoothAdapter.EXTRA_PREVIOUS_STATE,
                BluetoothAdapter.STATE_OFF
            )
            when (state) {
                BluetoothAdapter.STATE_TURNING_ON, BluetoothAdapter.STATE_ON -> {
                }
                BluetoothAdapter.STATE_TURNING_OFF, BluetoothAdapter.STATE_OFF -> if (previousState != BluetoothAdapter.STATE_TURNING_OFF && previousState != BluetoothAdapter.STATE_OFF) {
                }
            }
        }
    }

    /**
     * 使屏幕常亮 继承该Activity的页面也将常亮
     * Keep screen light Interface which inherits this activity also will keep light
     */
    fun keepScreenLongLight_MVP(activity: Activity) {
        val isOpenLight = true
        try {
            val window = activity.window
            if (isOpenLight) {
                window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            } else {
                window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
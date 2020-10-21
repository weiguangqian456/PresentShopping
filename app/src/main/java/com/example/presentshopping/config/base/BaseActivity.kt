package com.example.presentshopping.config.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.presentshopping.utils.edit.StatusBarUtil
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com 1
 * Description：
 */
abstract class BaseActivity : AppCompatActivity(), PermissionCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置布局
        setContentView(layoutId)
        /**
         * 设置状态栏透明：侵入式透明status bar
         *
         * 这里注意下 因为在评论区发现有网友调用setRootViewFitsSystemWindows 里面 winContent.getChildCount()=0 导致代码无法继续
         * 是因为你需要在setContentView之后才可以调用 setRootViewFitsSystemWindows
         */
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this, true)
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this)
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        //状态栏 黑白主题 切换： dark=>true:状态栏黑色图标; dark=>false:状态栏白色图标。
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this, 0x55000000)
        }

        // 初始化视图
        initView(savedInstanceState)
    }

    /**
     * 设置布局
     */
    abstract val layoutId: Int

    /**
     * 初始化视图
     */
    abstract fun initView(savedInstanceState: Bundle?)
    override fun onDestroy() {
        super.onDestroy()
    }
    // 使用EasyPermission权限库解决6.0权限问题，解决7.0 FileProvider问题，华为手机获取不到图库相片问题等等
    /**
     * 重写onRequestPermissionsResult，用于接受请求结果
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // EasyPermissions handles the request result. 将请求结果传递EasyPermission库处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    /**
     * 请求权限成功
     *
     * @param requestCode
     * @param perms
     */
    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        Log.d(TAG, "onPermissionsGranted:" + requestCode + ":" + perms.size)
        onPermissionsRequestSuccessfulOrFailed(requestCode, true, perms)
    }

    /**
     * 请求权限失败
     *
     * @param requestCode
     * @param perms
     */
    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        Log.d(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size)
        // (Optional) Check whether the user denied any permissions and checked "NEVER ASK AGAIN."
        // This will display a dialog directing them to enable the permission in app settings.
        /**
         * 若是在权限弹窗中，用户勾选了'NEVER ASK AGAIN.'或者'不在提示'，且拒绝权限。
         * 这时候，需要跳转到设置界面去，让用户手动开启。
         */
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    // 接收请求返回码
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // 当从软件设置界面，返回当前程序时候  
        // if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {   }
        // 重新检查权限是否开通。
        onPermissionsRequestSuccessfulOrFailed(requestCode, false, null)
    }

    /**
     * 权限请求成功 或 失败 回调。
     */
    fun onPermissionsRequestSuccessfulOrFailed(
        requestCode: Int,
        isSuccessful: Boolean,
        perms: List<String>?
    ) {
    }

    companion object {
        private const val TAG = "BaseActivity"
    }
}
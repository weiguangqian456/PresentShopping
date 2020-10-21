package com.example.presentshopping.config.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layoutId, container, false)


        // 初始化视图
        initView(view, savedInstanceState)
        return view
    }

    /**
     * 设置布局
     */
    protected abstract val layoutId: Int

    /**
     * 初始化视图
     */
    protected abstract fun initView(view: View?, savedInstanceState: Bundle?)
    override fun onDestroyView() {
        super.onDestroyView()
    }
}
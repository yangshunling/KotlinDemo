package com.example.kotlindemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getContentView(), null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //初始化BaseView
        initView()
        //初始化数据
        initData()
    }

    /**
     * 初始化布局
     */
    abstract fun initView()

    /**
     * 获取布局文件
     *
     * @return
     */
    abstract fun getContentView(): Int

    /**
     * 初始化数据（控件的赋值）
     */
    abstract fun initData()

    /**
     * 显示Toast
     *
     * @param msg
     */
    fun showToast(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }
}

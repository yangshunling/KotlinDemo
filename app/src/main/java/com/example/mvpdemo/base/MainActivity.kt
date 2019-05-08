package com.example.mvpdemo.base

import com.example.mvpdemo.R
import kotlinx.android.synthetic.main.activity_base.*

/**
 * @Description: MVPDemo
 * @Author: Anonymous
 * @Time: 2019-05-08 18:46
 */
class MainActivity : BaseActivity() {
    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initTopBar() {
        mTopbar.setTitle("首页")
    }

    override fun initData() {
    }

}
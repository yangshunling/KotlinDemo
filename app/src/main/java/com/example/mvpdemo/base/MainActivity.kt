package com.example.mvpdemo.base

import android.view.View
import com.example.mvpdemo.R
import com.example.mvpdemo.rxhttp.retrofit.ParamBuilder
import com.example.mvpdemo.rxhttp.retrofit.ServiceAPI
import com.example.mvpdemo.rxhttp.rxjava.RxResultFunc
import com.example.mvpdemo.rxhttp.rxjava.RxSubscriber
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

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
        button.setOnClickListener(View.OnClickListener {
            ServiceAPI.Retrofit().userLogin(ParamBuilder.newBody()
                    .addBody("mobile", "18058810112")
                    .addBody("password", "123456")
                    .bulidBody())
                    .map(RxResultFunc<Any>())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : RxSubscriber<Any>(this, "正在登录...") {
                        override fun onNext(token: Any) {
                            showToast("123")
                        }
                    })
        })
    }

}
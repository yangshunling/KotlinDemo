package com.example.mvpdemo.rxhttp.rxjava


import com.example.mvpdemo.rxhttp.exception.RxApiException

import rx.functions.Func1

/**
 * Created by Anonymous on 2017/4/6.
 */

class RxResultFunc<T> : Func1<RxMoudle<T>, T> {

    override fun call(httpResult: RxMoudle<T>): T? {
        if (!httpResult.isSucceed) {
            throw RxApiException(httpResult.code, httpResult.message)
        }
        return httpResult.data
    }
}


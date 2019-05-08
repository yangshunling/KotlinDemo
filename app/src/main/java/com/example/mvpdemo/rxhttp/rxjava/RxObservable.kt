package com.example.mvpdemo.rxhttp.rxjava

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Anonymous on 2017/8/22.
 */

class RxObservable<T> protected constructor(f: Observable.OnSubscribe<T>) : Observable<T>(f), Observable.Transformer<RxMoudle<T>, T> {

    override fun call(rxMoudleObservable: Observable<RxMoudle<T>>): Observable<T> {
        return rxMoudleObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(RxResultFunc())
    }
}


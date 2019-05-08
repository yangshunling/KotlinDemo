package com.example.mvpdemo.rxhttp.rxjava

/**
 * Created by Anonymous on 18/12/10.
 */
class RxMoudle<T> {

    /**
     * success : TRUE
     * code : Y00-000200
     * message : SUCCESS
     * data : {}
     * succeed : true
     * failed : false
     */

    var success: String? = null
    var code: String? = null
    var message: String? = null
    var data: T? = null
    var isSucceed: Boolean = false
    var isFailed: Boolean = false
}

package com.example.mvpdemo.rxhttp.retrofit;

import com.example.mvpdemo.rxhttp.rxjava.RxMoudle;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import rx.Observable;

/**
 * Retrofit API接口
 */

public interface RetrofitAPI {

    /**
     * 用户登录
     */
    @Multipart
    @POST("user/login")
    Observable<RxMoudle<Object>> userLogin(@PartMap Map<String, RequestBody> params);
}

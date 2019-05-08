package com.example.mvpdemo.rxhttp.okhttp;

import android.util.Log;

import com.example.mvpdemo.base.MyApplication;
import com.example.mvpdemo.utils.PreferencesUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp Token拦截器
 */

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        String token = PreferencesUtil.getToken(MyApplication.getContext());
        Log.v("token", token);
        if (token.equals("")) {
            return chain.proceed(original);
        }
        Request request = original.newBuilder()
                .header("Authorization", "Bearer " + token)
                .build();
        return chain.proceed(request);
    }
}

package com.example.mvpdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 全局信息的保存和取出
 */
public class PreferencesUtil {

    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;

    private static String token;

    /**
     * 保存用户Token
     *
     * @param context
     * @param token
     */
    public static void saveToken(Context context, String token) {
        editor = context.getSharedPreferences("token", Context.MODE_PRIVATE)
                .edit();
        editor.putString("token", token);//token
        editor.commit();
    }

    /**
     * 获取用户Token
     *
     * @param context
     * @return
     */
    public static String getToken(Context context) {
        pref = context.getSharedPreferences("token", Context.MODE_PRIVATE);
        token = pref.getString("token", "");
        return token;
    }

}

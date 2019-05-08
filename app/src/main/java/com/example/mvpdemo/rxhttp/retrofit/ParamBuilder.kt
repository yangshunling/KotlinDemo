package com.example.mvpdemo.rxhttp.retrofit

import java.io.File
import java.util.HashMap

import okhttp3.MediaType
import okhttp3.RequestBody

/**
 * 构造者模式
 *
 *
 * 功能
 * 一、构建Param参数（表单参数提交）
 * 二、构建Body请求体（多文件上传）
 *
 *
 * 构建流程：
 * 1、初始化
 * 2、构建
 * 3、返回
 */

class ParamBuilder
/**
 * 构建私有方法
 */
private constructor() {

    /**
     * 添加Param参数
     */
    fun addParam(key: String, value: String): ParamBuilder {
        params!![key] = value
        return this
    }

    /**
     * 添加Body参数
     */
    fun addBody(key: String, o: Any): ParamBuilder {
        if (o is String) {
            val body = RequestBody.create(MediaType.parse("text/plain"), o)
            paramBody!![key] = body
        } else if (o is File) {
            val body = RequestBody.create(MediaType.parse("multipart/form-data;charset=UTF-8"), o)
            paramBody!![key + "\"; filename=\"" + o.name + ""] = body
        }
        return this
    }

    /**
     * 构建Param
     */
    fun bulidParam(): Map<String, String>? {
        return params
    }

    /**
     * 构建Body
     */
    fun bulidBody(): Map<String, RequestBody>? {
        return paramBody
    }

    companion object {

        private var mParameterBuilder: ParamBuilder? = null
        private var params: MutableMap<String, String>? = null
        private var paramBody: MutableMap<String, RequestBody>? = null

        /**
         * 初始化Param参数对象
         */
        fun newParams(): ParamBuilder {
            if (mParameterBuilder == null) {
                mParameterBuilder = ParamBuilder()
            }
            params = HashMap()
            return mParameterBuilder as ParamBuilder
        }

        /**
         * 初始化Body参数对象
         */
        fun newBody(): ParamBuilder {
            if (mParameterBuilder == null) {
                mParameterBuilder = ParamBuilder()
            }
            paramBody = HashMap()
            return mParameterBuilder as ParamBuilder
        }
    }
}

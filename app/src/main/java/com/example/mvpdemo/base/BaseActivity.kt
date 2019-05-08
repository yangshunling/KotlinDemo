package com.example.mvpdemo.base

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast

import com.example.mvpdemo.R
import com.example.mvpdemo.callback.PermissionsCallback
import com.gyf.immersionbar.ImmersionBar

import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ktx.immersionBar
import kotlinx.android.synthetic.main.activity_base.*
import pub.devrel.easypermissions.EasyPermissions

/**
 * BaseActivity基类
 */
abstract class BaseActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    var mCallback: PermissionsCallback? = null

    private val perms = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA)

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        //初始化BaseView
        initView()
        //初始化TopBar
        initTopBar()
        //初始化数据
        initData()
    }

    /**
     * 初始化BaseView
     */
    private fun initView() {
        //沉浸式
        statusBar()
        //初始化TopBar
        topBar()
        //解析子布局
        resolveView()
    }

    /**
     * 初始化沉浸式
     */
    private fun statusBar() {
        immersionBar {
            statusBarColor(R.color.app_color)
            fitsSystemWindows(true)
        }
    }

    /**
     * 沉浸式图片
     */
    fun setTransparent() {
        immersionBar {
            fitsSystemWindows(false)
            transparentStatusBar()
        }
    }

    /**
     * 初始化TopBar
     */
    private fun topBar() {
        mTopbar.addLeftBackImageButton()
    }

    /**
     * 初始化Fragment
     */
    private fun resolveView() {
        //将继承 TopBarBaseActivity 的布局解析到 FrameLayout 里面
        LayoutInflater.from(this).inflate(getContentView(), mViewContent)
    }

    /**
     * 获取布局文件
     *
     * @return
     */
    abstract fun getContentView(): Int

    /**
     * 初始化TopBar
     */
    abstract fun initTopBar()

    /**
     * 初始化数据（控件的赋值）
     */
    abstract fun initData()

    /**
     * 动态权限接口定义
     *
     * @param callback
     */
    fun requestPermissions(callback: PermissionsCallback) {
        mCallback = callback
        if (EasyPermissions.hasPermissions(this, *perms)) {
            mCallback!!.onAccept()
        } else {
            EasyPermissions.requestPermissions(this, "请同意以下权限!", 100, *perms)
        }
    }

    /**
     * 动态权限回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    /**
     * 权限接受回调
     *
     * @param requestCode
     * @param perms
     */
    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        mCallback!!.onAccept()
    }

    /**
     * 权限拒绝回调
     *
     * @param requestCode
     * @param perms
     */
    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        mCallback!!.onDenied()
    }

    /**
     * 显示Toast
     *
     * @param msg
     */
    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

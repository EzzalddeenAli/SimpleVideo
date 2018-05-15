package cn.liucr.simplevideo.module.flash

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import cn.liucr.simplevideo.R
import cn.liucr.simplevideo.http.SohuHttpManager
import cn.liucr.simplevideo.module.main.MainActivity
import com.liucr.mvvmhelper.utils.LogUtil
import com.sohuvideo.api.SohuPlayerSDK
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class FlashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)
        checkSelfPermission()
    }

    /**
     * 检查必须权限是否开启
     */
    private fun checkSelfPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_PHONE_STATE), 1)
        } else {
            initSohuPlayerSDK()
        }

    }

    /**
     * 初始化搜狐sdk
     */
    private fun initSohuPlayerSDK() {
        SohuPlayerSDK.init(applicationContext)
        startActivity(Intent(this, MainActivity::class.java))
        supportFinishAfterTransition()
//        text()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {
            for (i in permissions.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    initSohuPlayerSDK()
                } else {
                    finish()
                }
            }
        }
    }

    @SuppressLint("CheckResult")
    private fun text() {
        SohuHttpManager.sohuApi.firstCate
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    LogUtil.d(it.toString())
                }, {
                    LogUtil.d(it.toString())
                })
    }

}
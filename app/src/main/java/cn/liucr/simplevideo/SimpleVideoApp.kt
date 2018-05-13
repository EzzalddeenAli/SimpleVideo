package cn.liucr.simplevideo

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

class SimpleVideoApp : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
    }

}
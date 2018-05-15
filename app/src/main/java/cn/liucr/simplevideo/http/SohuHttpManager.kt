package cn.liucr.simplevideo.http

import cn.liucr.simplevideo.http.interceptor.BasicParamsInterceptor
import com.liucr.mvvmhelper.http.HttpManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by liucr on 2018/4/25.
 */
class SohuHttpManager private constructor() : HttpManager() {

    private var mSohuApi: SohuApi? = null
    private var mSoHuHttpClient: OkHttpClient? = null

    private object LazyHolder {
        val INSTANCE = SohuHttpManager()
    }

    init {
        initSohuApi()
    }

    private fun initSohuApi() {

        val interceptor = BasicParamsInterceptor.Builder()
                .addQueryParam("api_key", ApiConstant.API_KEY)
                .build()

        mSoHuHttpClient = OkHttpClient.Builder()
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(interceptor)
                .build()
        mSohuApi = createService(SohuApi::class.java, ApiConstant.BASE_URL, mSoHuHttpClient)
    }

    companion object {

        val instance: SohuHttpManager
            get() = SohuHttpManager.LazyHolder.INSTANCE

        val sohuApi: SohuApi
            get() = SohuHttpManager.instance.mSohuApi!!
    }

}

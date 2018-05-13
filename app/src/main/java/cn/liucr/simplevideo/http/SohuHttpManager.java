package cn.liucr.simplevideo.http;

import com.liucr.mvvmhelper.http.HttpManager;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by liucr on 2018/4/25.
 */
public class SohuHttpManager extends HttpManager {

    private SohuApi mSohuApi;
    private OkHttpClient mSoHuHttpClient;

    private static class LazyHolder {
        private static final SohuHttpManager INSTANCE = new SohuHttpManager();
    }

    public static SohuHttpManager getInstance() {
        return SohuHttpManager.LazyHolder.INSTANCE;
    }

    private SohuHttpManager() {
        initDouBanApi();
    }

    private void initDouBanApi() {
        mSoHuHttpClient = new OkHttpClient.Builder()
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        mSohuApi = createService(SohuApi.class, ApiConstant.BASE_URL, mSoHuHttpClient);
    }

    public static SohuApi getDouBanApi() {
        return SohuHttpManager.getInstance().mSohuApi;
    }

}

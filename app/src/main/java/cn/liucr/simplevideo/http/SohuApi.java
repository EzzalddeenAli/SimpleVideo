package cn.liucr.simplevideo.http;

import cn.liucr.simplevideo.mode.sohu.Channel;
import cn.liucr.simplevideo.mode.sohu.FirstCate;
import cn.liucr.simplevideo.mode.sohu.SecondCate;
import cn.liucr.simplevideo.mode.sohu.SohuListResponse;
import cn.liucr.simplevideo.mode.sohu.SohuResponse;
import cn.liucr.simplevideo.mode.sohu.VideoInfo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by liucr on 2018/4/25.
 */
public interface SohuApi {

    @GET("category/pgc.json")
    Observable<SohuListResponse<FirstCate>> getFirstCate(@Query("api_key") String api_key);

    @GET("category/catecode/{cate_id}.json")
    Observable<SohuListResponse<SecondCate>> getSecondCate(
            @Path("cate_id") int cateId,
            @Query("api_key") String api_key);

    @GET("category/channel/{cid}.json")
    Observable<SohuResponse<Channel>> getChannel(
            @Path("cid") int cid,
            @Query("api_key") String api_key,
            @Query("O") int sort,
            @Query("page_size") int page_size,
            @Query("page") int page,
            @Query("is_pgc") Integer is_pgc,
            @Query("cat") Integer cat);

    @GET("video/info/{vid}.json")
    Observable<SohuListResponse<VideoInfo>> getVideoInfo(
            @Path("{vid}") int vid,
            @Query("api_key") String api_key,
            @Query("aid") Integer aid,
            @Query("site") Integer site);


}

package cn.liucr.simplevideo.http

import cn.liucr.simplevideo.mode.sohu.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by liucr on 2018/4/25.
 */
interface SohuApi {

    @get:GET("category/pgc.json")
    val firstCate: Observable<SohuListResponse<FirstCate>>

    @GET("category/catecode/{cate_id}.json")
    fun getSecondCate(
            @Path("cate_id") cateId: Int): Observable<SohuListResponse<SecondCate>>

    //https://open.mb.hd.sohu.com/v4/category/channel/{cid}.json
    @GET("category/channel/{cid}.json")
    fun getChannel(
            @Path("cid") cid: Int,
            @Query("o") sort: Int,
            @Query("page_size") page_size: Int,
            @Query("page") page: Int,
            @Query("is_pgc") is_pgc: Int,
            @Query("cat") cat: Int?): Observable<SohuResponse<Channel>>

    @GET("video/info/{vid}.json")
    fun getVideoInfo(
            @Path("{vid}") vid: Int,
            @Query("aid") aid: Int?,
            @Query("site") site: Int?): Observable<SohuListResponse<VideoInfo>>


}

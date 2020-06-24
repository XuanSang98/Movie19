package com.sunasterisk.movie19.data.api

import com.sunasterisk.movie19.data.model.Data
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    fun getUpcoming(@Query("page") page: Int): Observable<Data>

    @GET("movie/popular")
    fun getTopRated(@Query("page") page: Int): Observable<Data>

    @GET("movie/top_rated")
    fun getPopular(@Query("page") page: Int): Observable<Data>

    @GET("movie/upcoming")
    fun getNowPlaying(@Query("page") page: Int): Observable<Data>
}

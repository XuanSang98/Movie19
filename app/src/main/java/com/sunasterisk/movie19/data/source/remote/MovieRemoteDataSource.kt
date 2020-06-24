package com.sunasterisk.movie19.data.source.remote

import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.model.Data
import com.sunasterisk.movie19.data.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable

class MovieRemoteDataSource(private val api: ApiService) : MovieDataSource.Remote {

    override fun getUpcoming(page: Int): Observable<Data> = api.getUpcoming(page)

    override fun getTopRated(page: Int): Observable<Data> = api.getTopRated(page)

    override fun getPopular(page: Int): Observable<Data> = api.getPopular(page)

    override fun getNowPlaying(page: Int): Observable<Data> = api.getNowPlaying(page)
}

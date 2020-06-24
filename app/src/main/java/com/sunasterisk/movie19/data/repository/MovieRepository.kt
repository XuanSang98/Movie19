package com.sunasterisk.movie19.data.repository

import com.sunasterisk.movie19.data.model.Data
import com.sunasterisk.movie19.data.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable

class MovieRepository(
    private val remote: MovieDataSource.Remote
) : MovieDataSource.Remote {

    override fun getUpcoming(page: Int): Observable<Data> = remote.getUpcoming(page)

    override fun getTopRated(page: Int): Observable<Data> = remote.getTopRated(page)

    override fun getPopular(page: Int): Observable<Data> = remote.getPopular(page)

    override fun getNowPlaying(page: Int): Observable<Data> = remote.getNowPlaying(page)
}

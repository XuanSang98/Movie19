package com.sunasterisk.movie19.data.source

import com.sunasterisk.movie19.data.model.Data
import io.reactivex.rxjava3.core.Observable

interface MovieDataSource {
    interface Remote {
        fun getUpcoming(page: Int): Observable<Data>
        fun getTopRated(page: Int): Observable<Data>
        fun getPopular(page: Int): Observable<Data>
        fun getNowPlaying(page: Int): Observable<Data>
    }
}

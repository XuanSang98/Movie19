package com.sunasterisk.movie19.ui.movie

import androidx.databinding.ObservableField
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseViewModel
import com.sunasterisk.movie19.data.model.Data
import com.sunasterisk.movie19.data.model.MovieParent
import com.sunasterisk.movie19.data.repository.MovieRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Function4
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieViewModel(private val repository: MovieRepository) : BaseViewModel() {

    val movieParent = ObservableField<List<MovieParent>>()
    private lateinit var upComing: Observable<Data>
    private lateinit var topRated: Observable<Data>
    private lateinit var popular: Observable<Data>
    private lateinit var nowPlaying: Observable<Data>

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private fun getUpcoming(page: Int) {
        upComing = repository.getUpcoming(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getTopRated(page: Int) {
        topRated = repository.getTopRated(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getPopular(page: Int) {
        popular = repository.getPopular(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getNowPlaying(page: Int) {
        nowPlaying = repository.getNowPlaying(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getMovies() {
        getUpcoming(1)
        getTopRated(1)
        getPopular(1)
        getNowPlaying(1)

        Observable.zip(
            upComing,
            topRated,
            popular,
            nowPlaying,
            Function4 { upComing: Data,
                        topRated: Data,
                        popular: Data,
                        nowPlaying: Data
                ->
                configData(upComing, topRated, popular, nowPlaying)
            }).subscribe()
            .addTo(compositeDisposable)
    }

    private fun configData(upComing: Data, topRated: Data, popular: Data, nowPlaying: Data) {
        val list = listOf(
            MovieParent(R.string.text_section_upcoming, upComing.results),
            MovieParent(R.string.text_section_toprated, topRated.results),
            MovieParent(R.string.text_section_popular, popular.results),
            MovieParent(R.string.text_see_nowplaying, nowPlaying.results)
        )
        movieParent.set(list)
    }
}

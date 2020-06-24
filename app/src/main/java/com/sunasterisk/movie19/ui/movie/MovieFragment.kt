package com.sunasterisk.movie19.ui.movie

import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseFragment
import com.sunasterisk.movie19.data.api.ApiService
import com.sunasterisk.movie19.data.api.ServiceBuilder
import com.sunasterisk.movie19.data.repository.MovieRepository
import com.sunasterisk.movie19.data.source.remote.MovieRemoteDataSource
import com.sunasterisk.movie19.databinding.FragmentMovieBinding

class MovieFragment : BaseFragment<FragmentMovieBinding>() {

    private val movieParentAdapter: MovieParentAdapter = MovieParentAdapter()

    private val viewModel by lazy {
        val apiService = ServiceBuilder.buildService(ApiService::class.java)
        val movieRemoteDataSource = MovieRemoteDataSource(apiService)
        val movieRepository = MovieRepository(movieRemoteDataSource)
        MovieViewModel(movieRepository)
    }

    override val layoutId get() = R.layout.fragment_movie

    override fun initializeComponent() {
        binding.recyclerViewMovie.adapter = movieParentAdapter
        binding.viewModel = viewModel
        viewModel.getMovies()
    }
}

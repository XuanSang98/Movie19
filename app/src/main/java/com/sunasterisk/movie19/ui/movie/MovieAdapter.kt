package com.sunasterisk.movie19.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseAdapter
import com.sunasterisk.movie19.data.model.Movie
import com.sunasterisk.movie19.databinding.MovieChildItemBinding

class MovieAdapter : BaseAdapter<Movie, MovieViewHolder>(
    MovieTaskDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = DataBindingUtil.inflate<MovieChildItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.movie_child_item,
            parent,
            false
        )
        return MovieViewHolder(inflater)
    }
}

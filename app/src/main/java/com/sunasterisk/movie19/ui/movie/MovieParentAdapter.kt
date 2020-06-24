package com.sunasterisk.movie19.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.movie19.R
import com.sunasterisk.movie19.base.BaseAdapter
import com.sunasterisk.movie19.data.model.MovieParent
import com.sunasterisk.movie19.databinding.MovieParentItemBinding

class MovieParentAdapter : BaseAdapter<MovieParent, MovieParentViewHolder>(
    MovieParentTaskDiffCallback()
) {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieParentViewHolder {
        val inflater = DataBindingUtil.inflate<MovieParentItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.movie_parent_item,
            parent,
            false
        )
        return MovieParentViewHolder(inflater, viewPool)
    }
}

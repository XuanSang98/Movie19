package com.sunasterisk.movie19.ui.movie

import com.sunasterisk.movie19.BR
import com.sunasterisk.movie19.base.BaseViewHolder
import com.sunasterisk.movie19.data.model.Movie
import com.sunasterisk.movie19.databinding.MovieChildItemBinding

class MovieViewHolder(
    val databinding: MovieChildItemBinding
) : BaseViewHolder<Movie>(
    databinding.root
) {

    override fun bindData(item: Movie) {
        super.bindData(item)
        databinding.apply {
            setVariable(BR.movie, item)
            executePendingBindings()
            textViewMovie.isSelected = true
        }
    }
}

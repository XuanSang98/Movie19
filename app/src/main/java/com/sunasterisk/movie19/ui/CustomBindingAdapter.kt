package com.sunasterisk.movie19.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunasterisk.movie19.data.model.Genre
import com.sunasterisk.movie19.data.model.Movie
import com.sunasterisk.movie19.data.model.MovieParent
import com.sunasterisk.movie19.ui.category.adapter.GenreAdapter
import com.sunasterisk.movie19.ui.movie.adapter.MovieAdapter
import com.sunasterisk.movie19.ui.movie.adapter.MovieParentAdapter
import com.sunasterisk.movie19.utils.Constants

object CustomBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(image: ImageView, urlImage: String) {
        Glide.with(image.context)
            .load(Constants.IMAGE_URL + urlImage)
            .into(image)
    }

    @JvmStatic
    @BindingAdapter("dataMovie")
    fun setData(recyclerView: RecyclerView, items: List<Movie>?) {
        items?.let { (recyclerView.adapter as MovieAdapter).submitList(items) }
    }

    @JvmStatic
    @BindingAdapter("dataMovieParent")
    fun setDataMovieParent(recyclerView: RecyclerView, data: List<MovieParent>?) {
        data?.let { (recyclerView.adapter as MovieParentAdapter).submitList(data) }
    }

    @JvmStatic
    @BindingAdapter("dataGenre")
    fun getGenres(recyclerView: RecyclerView, genres: List<Genre>?) {
        genres?.let { (recyclerView.adapter as GenreAdapter).submitList(genres) }
    }
}

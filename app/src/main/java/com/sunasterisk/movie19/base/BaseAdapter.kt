package com.sunasterisk.movie19.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>(
    itemCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(
    itemCallback
) {
    override fun onBindViewHolder(holder: VH, position: Int) = holder.bindData(getItem(position))
}

package com.sunasterisk.movie19.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Genre(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
) : Parcelable

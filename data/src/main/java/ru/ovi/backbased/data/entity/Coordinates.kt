package ru.ovi.backbased.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

// "lon":34.283333,"lat":44.549999
@Parcelize
class Coordinates(
    @SerializedName("lon") val longitude: Double,
    @SerializedName("lat") val latitude: Double
) : Parcelable

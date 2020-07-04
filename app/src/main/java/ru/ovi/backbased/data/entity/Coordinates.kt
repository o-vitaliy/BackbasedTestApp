package ru.ovi.backbased.data.entity

import com.google.gson.annotations.SerializedName

//"lon":34.283333,"lat":44.549999
class Coordinates(
    @SerializedName("lon") val longitude: Double,
    @SerializedName("lat") val latitude: Double
)
package ru.ovi.backbased.data.entity

import com.google.gson.annotations.SerializedName
import ru.ovi.backbased.data.filter.FilterPropertyProvider

class CityEntity(
    // {"country":"UA","name":"Hurzuf","_id":707860,"coord":{"lon":34.283333,"lat":44.549999}},
    @SerializedName("_id") val id: Int,
    val country: String,
    val name: String,
    @SerializedName("coord") val coordinates: Coordinates
) : FilterPropertyProvider {
    class List : ArrayList<CityEntity>()

    override fun filterProperty(): String = name
}

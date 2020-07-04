package ru.ovi.backbased.data.cities

import com.google.gson.Gson
import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.loader.ContentLoader
import java.io.InputStreamReader

class CitiesAssetsDataSource(
    private val gson: Gson,
    private val contentLoader: ContentLoader
) : CitiesDataSource {

    override fun loadCities(): List<CityEntity> {
        val inputStream = contentLoader.load(CITIES_PATH)
        val reader = InputStreamReader(inputStream)
        return gson.fromJson<List<CityEntity>>(reader, CityEntity.List::class.java)
    }

    private companion object {
        const val CITIES_PATH = "cities.json"
    }

}
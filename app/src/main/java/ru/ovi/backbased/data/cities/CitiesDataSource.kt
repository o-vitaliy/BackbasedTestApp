package ru.ovi.backbased.data.cities

import ru.ovi.backbased.data.entity.CityEntity

interface CitiesDataSource {
    fun loadCities(): List<CityEntity>
}

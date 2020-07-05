package ru.ovi.backbased.data.cities

import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.entity.Coordinates

val items = listOf(
    CityEntity(
        1,
        "US",
        "Alabama",
        Coordinates(1.0, 1.0)
    ),
    CityEntity(
        1,
        "US",
        "Albuquerque",
        Coordinates(1.0, 1.0)
    ),
    CityEntity(
        1,
        "US",
        "Anaheim",
        Coordinates(1.0, 1.0)
    ),
    CityEntity(
        1,
        "US",
        "Arizona",
        Coordinates(1.0, 1.0)
    ),
    CityEntity(
        1,
        "AU",
        "Sydney",
        Coordinates(1.0, 1.0)
    )
)

val citiesMockDataSource = object : CitiesDataSource {
    override fun loadCities(): List<ru.ovi.backbased.data.entity.CityEntity> = items
}

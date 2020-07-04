package ru.ovi.backbased.data.cities

import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.filter.FilterDataProvider

class CitiesFilterDataProvider(
    private val citiesDataSource: CitiesDataSource
) : FilterDataProvider<CityEntity> {
    override fun load(): Collection<CityEntity> = citiesDataSource.loadCities()
}

package ru.ovi.backbased.domain.cities

import ru.ovi.backbased.data.entity.CityEntity

interface CitiesRepository {
    suspend fun load(query: String?): Collection<CityEntity>
}

package ru.ovi.backbased.domain.cities

interface CitiesRepository {
    suspend fun load(query: String?): Collection<ru.ovi.backbased.data.entity.CityEntity>
}

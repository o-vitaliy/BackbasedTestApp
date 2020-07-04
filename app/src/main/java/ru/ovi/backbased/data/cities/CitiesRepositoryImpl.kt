package ru.ovi.backbased.data.cities

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.filter.DataFilter
import ru.ovi.backbased.domain.cities.CitiesRepository

class CitiesRepositoryImpl(
    private val filter: DataFilter<CityEntity>
) : CitiesRepository {

    override suspend fun load(query: String?): Collection<CityEntity> =
        withContext(Dispatchers.IO) {
            filter.filter(query)
        }
}

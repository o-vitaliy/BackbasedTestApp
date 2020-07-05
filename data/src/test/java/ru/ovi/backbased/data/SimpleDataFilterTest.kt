package ru.ovi.backbased.data

import org.junit.Before
import ru.ovi.backbased.data.cities.citiesMockDataSource

class SimpleDataFilterTest : BaseDataFilterTest() {

    @Before
    fun setUp() {
        filter = ru.ovi.backbased.data.filter.SimpleDataFilter(
            ru.ovi.backbased.data.cities.CitiesFilterDataProvider(
                citiesMockDataSource
            )
        )
    }
}
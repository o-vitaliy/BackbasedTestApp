package ru.ovi.backbased.data

import org.junit.Before
import ru.ovi.backbased.data.cities.CitiesFilterDataProvider
import ru.ovi.backbased.data.cities.citiesMockDataSource
import ru.ovi.backbased.data.filter.SimpleDataFilter

class SimpleDataFilterTest : BaseDataFilterTest() {

    @Before
    fun setUp() {
        filter = SimpleDataFilter(
            CitiesFilterDataProvider(citiesMockDataSource)
        )
    }
}
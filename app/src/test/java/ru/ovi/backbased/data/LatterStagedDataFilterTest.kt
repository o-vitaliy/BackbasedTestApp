package ru.ovi.backbased.data

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.ovi.backbased.data.cities.CitiesFilterDataProvider
import ru.ovi.backbased.data.cities.citiesMockDataSource
import ru.ovi.backbased.data.filter.LetterStagedDataFilter

class LatterStagedDataFilterTest : BaseDataFilterTest() {

    @Before
    fun setUp() {
        filter = LetterStagedDataFilter(
            CitiesFilterDataProvider(citiesMockDataSource)
        )
    }

    @Test
    fun testFilterList_expectSingleRow() {
        val cities = citiesMockDataSource.loadCities()

        val result = LetterStagedDataFilter.filterListByLatter('S', 0, cities)
        assertEquals(1, result.size)
    }

    @Test
    fun testFilterList_expectThreeRows() {
        val cities = citiesMockDataSource.loadCities()

        val result = LetterStagedDataFilter.filterListByLatter('A', 0, cities)
        assertEquals(4, result.size)
    }

    @Test
    fun testFilterList_FilterTwoTimes() {
        val cities = citiesMockDataSource.loadCities()

        val r1 = LetterStagedDataFilter.filterListByLatter('A', 0, cities)
        val result = LetterStagedDataFilter.filterListByLatter('l', 1, r1)
        assertEquals(2, result.size)
    }
}
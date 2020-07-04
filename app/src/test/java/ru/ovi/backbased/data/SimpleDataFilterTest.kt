package ru.ovi.backbased.data

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.ovi.backbased.data.cities.CitiesFilterDataProvider
import ru.ovi.backbased.data.cities.citiesMockDataSource
import ru.ovi.backbased.data.cities.items
import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.filter.SimpleDataFilter

class SimpleDataFilterTest {

    lateinit var filter: SimpleDataFilter<CityEntity>

    @Before
    fun setUp() {
        filter = SimpleDataFilter(
            CitiesFilterDataProvider(citiesMockDataSource)
        )
    }

    @Test
    fun testFilterEmptyQuery() {
        val result = filter.filter(null)
        assertEquals("expected size is not " + items.size, items.size, result.size)
    }

    @Test
    fun testFilterNotExistingCity() {
        val result = filter.filter("aaaaaaaaaaa")
        assertEquals("expected size is not " + 0, 0, result.size)
    }


    @Test
    fun testFilterByFirstLetterInLowerCase() {
        val result = filter.filter("a")
        assertEquals("expected size is not " + 0, 4, result.size)
    }

    @Test
    fun testFilterByFirstLetterInUpperCase() {
        val result = filter.filter("A")
        assertEquals("expected size is not " + 0, 4, result.size)
    }

    @Test
    fun testFilterByTwoLetters() {
        val result = filter.filter("al")
        assertEquals("expected size is not " + 0, 2, result.size)
    }

    @Test
    fun testFilterFindSingleWord() {
        val result = filter.filter("S")
        assertEquals("expected size is not " + 0, 1, result.size)
    }

    @Test
    fun testFilterFindSingleWord2() {
        val result = filter.filter("Sydney")
        assertEquals("expected size is not " + 0, 1, result.size)
    }
}
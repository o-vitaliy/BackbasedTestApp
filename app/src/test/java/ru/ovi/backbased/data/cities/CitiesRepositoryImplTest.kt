package ru.ovi.backbased.data.cities

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import ru.ovi.backbased.data.filter.SimpleDataFilter
import ru.ovi.backbased.domain.cities.CitiesRepository

class CitiesRepositoryImplTest {
    lateinit var repo: CitiesRepository

    @Before
    fun setUp() {
        val filter = SimpleDataFilter(
            CitiesFilterDataProvider(citiesMockDataSource)
        )

        repo = CitiesRepositoryImpl(filter)
    }

    @Test
    fun testFilterEmptyQuery() {
        val result = runBlocking { repo.load(null) }
        Assert.assertEquals("expected size is not " + items.size, items.size, result.size)
    }

    @Test
    fun testFilterNotExistingCity() {
        val result = runBlocking { repo.load("aaaaaaaaaaa") }
        Assert.assertEquals("expected size is not " + 0, 0, result.size)
    }

    @Test
    fun testFilterByFirstLetterInLowerCase() {
        val result = runBlocking { repo.load("a") }
        Assert.assertEquals("expected size is not " + 0, 4, result.size)
    }
}
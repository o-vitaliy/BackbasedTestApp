package ru.ovi.backbased.data.cities

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.filter.FilterDataProvider

class CitiesFilterProviderTest {

    lateinit var provider: FilterDataProvider<CityEntity>

    @Before
    fun setUp() {
        provider = CitiesFilterDataProvider(citiesMockDataSource)
    }

    @Test
    fun testLoaded() {
        val result = provider.load()
        assertNotNull("result is null", result)
        assertTrue("result is empty", result.isNotEmpty())
    }
}
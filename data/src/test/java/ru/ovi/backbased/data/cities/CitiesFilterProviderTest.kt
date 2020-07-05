package ru.ovi.backbased.data.cities

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CitiesFilterProviderTest {

    lateinit var provider: ru.ovi.backbased.data.filter.FilterDataProvider<ru.ovi.backbased.data.entity.CityEntity>

    @Before
    fun setUp() {
        provider = ru.ovi.backbased.data.cities.CitiesFilterDataProvider(
            citiesMockDataSource
        )
    }

    @Test
    fun testLoaded() {
        val result = provider.load()
        assertNotNull("result is null", result)
        assertTrue("result is empty", result.isNotEmpty())
    }
}
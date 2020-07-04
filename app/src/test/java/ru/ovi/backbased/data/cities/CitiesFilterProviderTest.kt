package ru.ovi.backbased.data.cities

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.filter.FilterDataProvider

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
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
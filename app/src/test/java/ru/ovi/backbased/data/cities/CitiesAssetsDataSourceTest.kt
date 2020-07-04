package ru.ovi.backbased.data.cities

import android.os.Build
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import ru.ovi.backbased.App
import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.loader.AssetsContentLoader

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class CitiesAssetsDataSourceTest {

    lateinit var dataSource: CitiesDataSource

    @Before
    fun setUp() {
        val app = ApplicationProvider.getApplicationContext<App>()
        val contentLoader = AssetsContentLoader(app)

        dataSource = CitiesAssetsDataSource(
            Gson(),
            contentLoader
        )
    }

    @Test
    fun testCitiesLoaded() {
        val cities = dataSource.loadCities()
        assertNotNull("cities is null", cities)
        assertTrue("cities is empty", cities.isNotEmpty())

        val firstCity = cities.first()
        assertThat(firstCity, instanceOf(CityEntity::class.java))
        assertEquals("BE", firstCity.country)
        assertEquals("'t Hoeksken", firstCity.name)
        assertNotNull("coordinates are empty", firstCity.coordinates)
    }
}
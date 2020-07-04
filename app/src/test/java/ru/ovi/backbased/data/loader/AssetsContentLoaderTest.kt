package ru.ovi.backbased.data.loader

import android.os.Build
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import ru.ovi.backbased.App

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class AssetsContentLoaderTest {

    lateinit var contentLoader: ContentLoader

    @Before
    fun setUp() {
        val app = getApplicationContext<App>()
        contentLoader = AssetsContentLoader(app)
    }


    @Test
    fun openExistingPath() {
        val inputStream = contentLoader.load("cities.json")
        assertNotNull("assert inout stream is not null", inputStream)

        val notEmpty = inputStream.available() > 0
        assertTrue("assert inout stream is not empty", notEmpty)
    }

    @Test(expected = Exception::class)
    fun failOpeningNonExistingPath() {
        contentLoader.load("non_existing_path.json")
    }


}
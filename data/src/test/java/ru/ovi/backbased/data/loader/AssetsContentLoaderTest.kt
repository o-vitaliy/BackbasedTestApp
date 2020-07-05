package ru.ovi.backbased.data.loader

import android.content.Context
import android.os.Build
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class AssetsContentLoaderTest {

    lateinit var contentLoader: ContentLoader

    @Before
    fun setUp() {
        val app = getApplicationContext<Context>()
        contentLoader = AssetsContentLoader(app)
    }

    @Test
    fun openExistingPath() {
        val inputStream = contentLoader.load("cities.json")
        assertNotNull("inout stream is null", inputStream)

        val notEmpty = inputStream.available() > 0
        assertTrue("inout stream is empty", notEmpty)
    }

    @Test(expected = Exception::class)
    fun failOpeningNonExistingPath() {
        contentLoader.load("non_existing_path.json")
    }
}
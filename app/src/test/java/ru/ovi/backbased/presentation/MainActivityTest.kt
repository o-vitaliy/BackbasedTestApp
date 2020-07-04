package ru.ovi.backbased.presentation

import android.os.Build
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import ru.ovi.backbased.R
import ru.ovi.backbased.presentation.cities.CitiesFragment

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class MainActivityTest {

    @Test
    fun testMainActivityLaunching() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        scenario.onActivity {
            val fragment = it.supportFragmentManager.fragments.first()
            assertNotNull(fragment)
        }
    }

    @Test
    fun testCitiesFragmentIsVisible() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        scenario.onActivity {
            val fragment = it.supportFragmentManager.fragments.first()

            val currentDestination = fragment.findNavController().currentDestination
            assertNotNull(currentDestination)
            val className = (currentDestination as FragmentNavigator.Destination).className
            assertEquals(className,CitiesFragment::class.java.name)
        }
    }
}
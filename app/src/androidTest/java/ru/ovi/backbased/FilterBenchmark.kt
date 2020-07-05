package ru.ovi.backbased

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.backbased.data.dataModule
import kotlin.system.measureNanoTime

@RunWith(AndroidJUnit4::class)
class FilterBenchmark : KodeinAware {

    private val filtersModule = Kodein.Module(name = "filtersModule") {
        bind<ru.ovi.backbased.data.filter.SimpleDataFilter<ru.ovi.backbased.data.entity.CityEntity>>() with singleton {
            ru.ovi.backbased.data.filter.SimpleDataFilter<ru.ovi.backbased.data.entity.CityEntity>(
                instance()
            )
        }
        bind<ru.ovi.backbased.data.filter.LetterStagedDataFilter<ru.ovi.backbased.data.entity.CityEntity>>() with singleton {
            ru.ovi.backbased.data.filter.LetterStagedDataFilter<ru.ovi.backbased.data.entity.CityEntity>(
                instance()
            )
        }
    }
    override val kodein: Kodein by Kodein.lazy {
        import(androidXModule(ApplicationProvider.getApplicationContext<Context>() as App))
        import(dataModule)
        import(filtersModule)
    }


    @Test
    fun testSimpleFilter() {
        val filter: ru.ovi.backbased.data.filter.SimpleDataFilter<ru.ovi.backbased.data.entity.CityEntity> by instance()
        runFiltering(filter)
    }

    @Test
    fun testStageFilter() {
        val filter: ru.ovi.backbased.data.filter.LetterStagedDataFilter<ru.ovi.backbased.data.entity.CityEntity> by instance()
        runFiltering(filter)
    }


    private fun runFiltering(filter: ru.ovi.backbased.data.filter.DataFilter<ru.ovi.backbased.data.entity.CityEntity>) {
        filter.filter(null)
        val t = measureNanoTime {
            filter.filter(null)
            filter.filter("a")
            filter.filter("ab")
            filter.filter("")
        }

        println("done in $t by ${filter::class.java.name}")
    }
}
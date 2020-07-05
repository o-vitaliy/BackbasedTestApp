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
import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.filter.DataFilter
import ru.ovi.backbased.data.filter.LetterStagedDataFilter
import ru.ovi.backbased.data.filter.SimpleDataFilter
import kotlin.system.measureNanoTime

@RunWith(AndroidJUnit4::class)
class FilterBenchmark : KodeinAware {

    private val filtersModule = Kodein.Module(name = "filtersModule") {
        bind<SimpleDataFilter<CityEntity>>() with singleton {
            SimpleDataFilter<CityEntity>(
                instance()
            )
        }
        bind<LetterStagedDataFilter<CityEntity>>() with singleton {
            LetterStagedDataFilter<CityEntity>(
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
        val filter: SimpleDataFilter<CityEntity> by instance()
        runFiltering(filter)
    }

    @Test
    fun testStageFilter() {
        val filter: LetterStagedDataFilter<CityEntity> by instance()
        runFiltering(filter)
    }

    private fun runFiltering(filter: DataFilter<CityEntity>) {
        filter.filter(null)
        val city = "Zaponor’ye"

        for (i in city.indices) {
            val query = city.substring(0, i)
            val t = measureNanoTime {
                filter.filter(query)
            }
            println("Filter ${filter::class.java.canonicalName} query: $query done at $t")
        }
    }
}

package ru.ovi.backbased.data

import android.content.SharedPreferences
import com.google.gson.Gson
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.backbased.data.cities.CitiesAssetsDataSource
import ru.ovi.backbased.data.cities.CitiesDataSource
import ru.ovi.backbased.data.cities.CitiesFilterDataProvider
import ru.ovi.backbased.data.entity.CityEntity
import ru.ovi.backbased.data.filter.DataFilter
import ru.ovi.backbased.data.filter.FilterDataProvider
import ru.ovi.backbased.data.filter.LetterStagedDataFilter
import ru.ovi.backbased.data.loader.AssetsContentLoader
import ru.perevozka24.perevozka24.data.prefs.PrefsSourceFactory

val dataModule = Kodein.Module("data") {
    bind<SharedPreferences>() with singleton {
        PrefsSourceFactory.create(instance())
    }

    bind<Gson>() with singleton { GsonFactory.create() }

    bind<DataFilter<CityEntity>>() with singleton {
        LetterStagedDataFilter<CityEntity>(
            instance()
        )
    }

    bind<ResourceProvider>() with singleton {
        ResourceProvider(instance())
    }

    bind<ru.ovi.backbased.data.loader.ContentLoader>() with singleton {
        AssetsContentLoader(instance())
    }

    bind<CitiesDataSource>() with singleton {
        CitiesAssetsDataSource(
            instance(),
            instance()
        )
    }

    bind<FilterDataProvider<CityEntity>>() with singleton {
        CitiesFilterDataProvider(instance())
    }
}

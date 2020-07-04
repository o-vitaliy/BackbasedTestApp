package ru.ovi.backbased.data.di

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.backbased.data.cities.CitiesRepositoryImpl
import ru.ovi.backbased.domain.cities.CitiesRepository

val repositoryModule = Kodein.Module("repository") {

    bind<CitiesRepository>() with singleton {
        CitiesRepositoryImpl(instance())
    }
}

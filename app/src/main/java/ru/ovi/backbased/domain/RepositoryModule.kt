package ru.ovi.backbased.domain

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.backbased.domain.cities.CitiesRepository
import ru.ovi.backbased.domain.cities.CitiesRepositoryImpl

val repositoryModule = Kodein.Module("repository") {

    bind<CitiesRepository>() with singleton {
        CitiesRepositoryImpl(instance())
    }
}

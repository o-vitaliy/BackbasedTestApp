package ru.ovi.backbased.presentation

import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.backbased.presentation.cities.CitiesViewModel

val viewModelModule = Kodein.Module(name = "viewModelModule") {
    bind<ViewModelProvider.Factory>() with singleton {
        KodeinViewModelFactory(kodein)
    }

    bind<CitiesViewModel>() with singleton { CitiesViewModel(instance(), instance()) }
}

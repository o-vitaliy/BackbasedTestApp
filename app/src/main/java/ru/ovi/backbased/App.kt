package ru.ovi.backbased

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import ru.ovi.backbased.data.di.dataModule
import ru.ovi.backbased.data.di.repositoryModule
import ru.ovi.backbased.presentation.viewModelModule

class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(androidXModule(this@App))
        import(dataModule)
        import(repositoryModule)
        import(viewModelModule)
    }
}

package ru.ovi.backbased.data.di

import android.content.SharedPreferences
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.backbased.data.transactions.TransactionDataSource
import ru.ovi.backbased.data.transactions.TransactionRemoteDataSource
import ru.ovi.backbased.domain.common.ResourceProvider
import ru.perevozka24.perevozka24.data.prefs.PrefsSourceFactory

val dataModule = Kodein.Module("data") {
    bind<SharedPreferences>() with singleton {
        PrefsSourceFactory.create(instance())
    }

    bind<ResourceProvider>() with singleton {
        ResourceProvider(instance())
    }

    bind<TransactionDataSource>() with singleton {
        TransactionRemoteDataSource()
    }
}

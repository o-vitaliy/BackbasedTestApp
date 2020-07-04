package ru.ovi.backbased.data.di

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.backbased.data.transactions.TransactionRepositoryImpl
import ru.ovi.backbased.domain.transactions.TransactionRepository

val repositoryModule = Kodein.Module("repository") {
    bind<TransactionRepository>() with singleton {
        TransactionRepositoryImpl(instance())
    }
}

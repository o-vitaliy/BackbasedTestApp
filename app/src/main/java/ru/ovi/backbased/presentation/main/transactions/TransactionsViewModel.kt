package ru.ovi.backbased.presentation.main.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.ovi.backbased.domain.common.ResourceProvider
import ru.ovi.backbased.domain.common.Result
import ru.ovi.backbased.domain.transactions.TransactionListModel
import ru.ovi.backbased.domain.transactions.TransactionRepository
import ru.ovi.backbased.presentation.common.BaseViewModel

class TransactionsViewModel(
    private val transactionRepository: TransactionRepository,
    resourceProvider: ResourceProvider
) : BaseViewModel(resourceProvider) {

    val transactions: LiveData<Result<TransactionListModel>> = MutableLiveData()

    init {
       /* launch(transactions) {
            transactionRepository.getTransactions()
        }*/
    }
}

package ru.ovi.backbased.presentation.main.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.ovi.backbased.domain.common.ResourceProvider
import ru.ovi.backbased.domain.common.Result
import ru.ovi.backbased.domain.transactions.TransactionModel
import ru.ovi.backbased.domain.transactions.TransactionRepository
import ru.ovi.backbased.presentation.common.BaseViewModel

class DetailsTransactionViewModel(
    private val transactionRepository: TransactionRepository,
    resourceProvider: ResourceProvider
) : BaseViewModel(resourceProvider) {
    val transactions: LiveData<Result<TransactionModel>> = MutableLiveData()

    fun init(ref: String) {
        launch(transactions) {
            transactionRepository.getTransaction(ref)
        }
    }
}

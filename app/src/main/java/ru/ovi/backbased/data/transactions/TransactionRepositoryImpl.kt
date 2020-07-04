package ru.ovi.backbased.data.transactions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ovi.backbased.domain.transactions.TransactionListModel
import ru.ovi.backbased.domain.transactions.TransactionModel
import ru.ovi.backbased.domain.transactions.TransactionRepository

class TransactionRepositoryImpl(
    private val transactionDataSource: TransactionDataSource
) : TransactionRepository {
    override suspend fun getTransactions(): TransactionListModel {
        return withContext(Dispatchers.IO) {
            val transactions = transactionDataSource.getTransactions().transactions
            val average = TransactionsHelper.calculateAverage(transactions)
            val total = TransactionsHelper.calculateTotal(transactions)
            TransactionListModel(transactions.map {
                TransactionModel(it.ref, it.destAmount, it.status)
            }, average, total)
        }
    }

    override suspend fun getTransaction(ref: String): TransactionModel {
        return withContext(Dispatchers.IO) {
            val transactions = transactionDataSource.getTransaction(ref).transactions
            transactions.map {
                TransactionModel(it.ref, it.destAmount, it.status)
            }.first()
        }
    }
}

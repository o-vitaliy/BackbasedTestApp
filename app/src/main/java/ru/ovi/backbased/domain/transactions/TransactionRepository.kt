package ru.ovi.backbased.domain.transactions

interface TransactionRepository {

    suspend fun getTransactions(): TransactionListModel
    suspend fun getTransaction(ref:String): TransactionModel
}

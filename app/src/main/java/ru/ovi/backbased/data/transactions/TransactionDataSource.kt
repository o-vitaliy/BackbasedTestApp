package ru.ovi.backbased.data.transactions

import ru.ovi.backbased.data.transactions.response.TransactionsResponse

interface TransactionDataSource {
    suspend fun getTransactions(): TransactionsResponse
    suspend fun getTransaction(ref: String): TransactionsResponse
}

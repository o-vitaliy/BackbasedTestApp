package ru.ovi.backbased.data.transactions

import ru.ovi.backbased.data.transactions.response.TransactionsResponse

class TransactionRemoteDataSource : TransactionDataSource {
    override suspend fun getTransactions(): TransactionsResponse {
        TODO()
    }

    override suspend fun getTransaction(ref: String): TransactionsResponse {
        TODO()
    }
}

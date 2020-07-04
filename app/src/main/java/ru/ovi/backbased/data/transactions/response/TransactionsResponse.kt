package ru.ovi.backbased.data.transactions.response

import ru.ovi.backbased.data.entity.TransactionEntity

data class TransactionsResponse(
    val transactions: List<TransactionEntity>
)

package ru.ovi.backbased.domain.transactions

import ru.ovi.backbased.domain.common.ContentModel

data class TransactionListModel(
    val transactions: List<TransactionModel>,
    val average: Double?,
    val total: Double
) : ContentModel {
    override fun isEmpty(): Boolean = transactions.isEmpty()
}

package ru.ovi.backbased.data.transactions

import ru.ovi.backbased.data.entity.TransactionEntity

object TransactionsHelper {

    fun calculateTotal(list: List<TransactionEntity>): Double {
        return list.sumByDouble { it.destAmount }
    }

    fun calculateAverage(list: List<TransactionEntity>): Double? {
        return list.takeIf { it.isNotEmpty() }?.let {
            calculateTotal(it) / it.size
        }
    }
}

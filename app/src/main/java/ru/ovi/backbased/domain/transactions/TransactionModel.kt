package ru.ovi.backbased.domain.transactions

data class TransactionModel(
    val ref: String,
    val destAmount: Double,
    val status: String
)

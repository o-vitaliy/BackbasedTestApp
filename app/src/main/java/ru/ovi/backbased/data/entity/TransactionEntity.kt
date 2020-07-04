package ru.ovi.backbased.data.entity

import com.google.gson.annotations.SerializedName

data class TransactionEntity(
    @SerializedName("transaction_reference") val ref: String,
    @SerializedName("dest_amount") val destAmount: Double,
    @SerializedName("status_message") val status: String
)

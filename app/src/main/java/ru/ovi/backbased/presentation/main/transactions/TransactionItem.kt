package ru.ovi.backbased.presentation.main.transactions

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_transaction.view.*
import ru.ovi.backbased.R
import ru.ovi.backbased.domain.transactions.TransactionModel

class TransactionItem(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(transaction: TransactionModel) {
        with(itemView) {
            itemTransactionDate.text = ""

            setOnClickListener {
                val bundle = bundleOf("ref" to transaction.ref)
                findNavController().navigate(
                    R.id.action_transactions_to_detialsTransactionFragment,
                    bundle
                )
            }
        }
    }

    companion object {
        val LAYOUT_ID = R.layout.item_transaction
        private const val DATE_FORMAT = "yyyy-MM-dd HH:mm"
    }
}

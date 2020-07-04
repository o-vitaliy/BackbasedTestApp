package ru.ovi.backbased.presentation.main.transactions

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.content_transactions.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import ru.ovi.backbased.R
import ru.ovi.backbased.domain.common.Result
import ru.ovi.backbased.presentation.common.BaseContentLoaderFragment
import ru.ovi.backbased.presentation.common.toPrice
import ru.ovi.backbased.presentation.viewModel

class TransactionsFragment : BaseContentLoaderFragment(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val viewModel: TransactionsViewModel by viewModel()

    override val contentLayoutId: Int = R.layout.content_transactions

    private val adapter = ItemsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe(viewModel.transactions)

        transactionsList.adapter = adapter

        viewModel.transactions.observe(viewLifecycleOwner, Observer {
            val value = (viewModel.transactions.value as? Result.Success)?.data ?: return@Observer

            transactionsAverageAmount.text = value.average?.toPrice() ?: ""
            transactionsSummaryAmount.text = value.total.toPrice()

            //adapter.update(value.transactions.map { TransactionItem(it) })
        })
    }
}

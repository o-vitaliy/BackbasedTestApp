package ru.ovi.backbased.presentation.main.details

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.content_transactions.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import ru.ovi.backbased.R
import ru.ovi.backbased.presentation.common.BaseContentLoaderFragment
import ru.ovi.backbased.presentation.main.transactions.ItemsAdapter
import ru.ovi.backbased.presentation.viewModel

class DetialsTransactionFragment : BaseContentLoaderFragment(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val viewModel: DetailsTransactionViewModel by viewModel()

    override val contentLayoutId: Int = R.layout.content_transactions

    private val adapter = ItemsAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ref = checkNotNull(arguments?.getString("ref"))
        viewModel.init(ref)

        subscribe(viewModel.transactions)
        transactionsList.adapter = adapter
    }
}
